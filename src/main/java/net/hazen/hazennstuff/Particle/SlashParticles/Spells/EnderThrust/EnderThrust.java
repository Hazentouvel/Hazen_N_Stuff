package net.hazen.hazennstuff.Particle.SlashParticles.Spells.EnderThrust;

import com.mojang.blaze3d.vertex.VertexConsumer;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

public class EnderThrust extends TextureSheetParticle {
    private final SpriteSet sprites;
    private final Vec3 forward;
    private final boolean mirror;
    private final boolean vertical;

    EnderThrust(ClientLevel pLevel, double pX, double pY, double pZ, SpriteSet spriteSet, double xd, double yd, double zd, EnderThrustOptions options) {
        super(pLevel, pX, pY, pZ, (double)0.0F, (double)0.0F, (double)0.0F);
        this.xd = xd;
        this.yd = yd;
        this.zd = zd;
        this.lifetime = 5;
        this.gravity = 0.0F;
        this.sprites = spriteSet;
        this.quadSize = options.scale * 3.25F;
        this.forward = (new Vec3((double)options.xf, (double)options.yf, (double)options.zf)).normalize();
        this.mirror = options.mirror;
        this.vertical = options.vertical;
        this.friction = 1.0F;
    }

    private Vec3 vec3Copy(Vector3f vector3f) {
        return new Vec3((double)vector3f.x, (double)vector3f.y, (double)vector3f.z);
    }

    public void tick() {
        if (this.age == 0) {
            this.createEnderParticle();
        }

        if (this.age++ > this.lifetime) {
            this.remove();
        } else {
            this.setSpriteFromAge(this.sprites);
        }

    }

    private void createEnderParticle() {
        int particleCount = (int)(15.0F * this.quadSize);
        Vector3f[] localVertices = this.calculateVertices(false);

        for(int i = 1; i < particleCount - 1; ++i) {
            float t = (float)i / (float)particleCount;
            float u = 1.0F - t;
            Vec3 localPos = this.vec3Copy(localVertices[1]).scale(0.4).scale((double)(u * u * u)).add(this.vec3Copy(localVertices[2]).scale((double)(3.0F * u * u * t)).add(this.vec3Copy(localVertices[3]).scale((double)(3.0F * u * t * t)).add(this.vec3Copy(localVertices[0]).scale(0.85).scale((double)(t * t * t))))).scale((double)this.quadSize * 0.85);
            Vec3 pos = localPos.add(Utils.getRandomVec3(0.2 + (double)((float)i * 0.01F)));
            Vec3 motion = (new Vec3(this.xd, this.yd, this.zd)).scale(this.random.nextDouble() * (double)6.0F);
            if (this.random.nextFloat() < 0.5F) {
                this.level.addParticle(ParticleHelper.UNSTABLE_ENDER, this.x + pos.x, this.y + pos.y, this.z + pos.z, motion.x * (double)1.5F, motion.y * (double)1.5F, motion.z * (double)1.5F);
            }
        }

    }

    private Vector3f[] calculateVertices(boolean verticalPlane) {
        Vec3 forward = this.forward;
        // Prevent invalid geometry if the direction is zero.
        if (forward.lengthSqr() < 1.0E-6) {
            forward = new Vec3(0, 0, 1);
        }

        // Choose a reference up vector that isn't parallel to forward.
        Vec3 worldUp = new Vec3(0, 1, 0);

        if (Math.abs(forward.dot(worldUp)) > 0.999) {
            worldUp = new Vec3(1, 0, 0);
        }

        Vec3 right = forward.cross(worldUp).normalize();
        Vec3 up = right.cross(forward).normalize();

        // Both planes extend along the thrust direction.
        Vec3 secondary = verticalPlane ? up : right;

        Vector3f[] vertices = new Vector3f[] {
                new Vector3f(-1, -1, 0),
                new Vector3f(-1,  1, 0),
                new Vector3f( 1,  1, 0),
                new Vector3f( 1, -1, 0)
        };

        for (int i = 0; i < vertices.length; i++) {float a = vertices[i].x;float b = vertices[i].y;

            Vec3 pos = forward.scale(a).add(secondary.scale(b));

            vertices[i] = new Vector3f((float) pos.x, (float) pos.y, (float) pos.z);
        }

        return vertices;
    }

    public Vec3 proj(Vec3 u, Vec3 v) {
        return u.scale(v.dot(u) / u.lengthSqr());
    }

    public void render(VertexConsumer buffer, Camera camera, float partialTick) {
        Vec3 cameraPos = camera.getPosition();

        float x = (float) (
                Mth.lerp((double) partialTick, this.xo, this.x) - cameraPos.x
        );
        float y = (float) (
                Mth.lerp((double) partialTick, this.yo, this.y) - cameraPos.y
        );
        float z = (float) (
                Mth.lerp((double) partialTick, this.zo, this.z) - cameraPos.z
        );

        float size = this.getQuadSize(partialTick);
        int light = this.getLightColor(partialTick);

        renderPlane(buffer, x, y, z, size, light, false);
        renderPlane(buffer, x, y, z, size, light, true);
    }

    private void renderPlane(VertexConsumer buffer, float x, float y, float z, float size, int light, boolean verticalPlane) {
        Vector3f[] vertices = calculateVertices(verticalPlane);
        boolean mirrored = !this.mirror;

        for (Vector3f vertex : vertices) {
            vertex.mul(size);
            vertex.add(x, y, z);
        }

        makeCornerVertex(buffer, vertices[0], getU1(), mirrored ? getV0() : getV1(), light);
        makeCornerVertex(buffer, vertices[1], getU1(), mirrored ? getV1() : getV0(), light);
        makeCornerVertex(buffer, vertices[2], getU0(), mirrored ? getV1() : getV0(), light);
        makeCornerVertex(buffer, vertices[3], getU0(), mirrored ? getV0() : getV1(), light);

        makeCornerVertex(buffer, vertices[3], getU0(), mirrored ? getV0() : getV1(), light);
        makeCornerVertex(buffer, vertices[2], getU0(), mirrored ? getV1() : getV0(), light);
        makeCornerVertex(buffer, vertices[1], getU1(), mirrored ? getV1() : getV0(), light);
        makeCornerVertex(buffer, vertices[0], getU1(), mirrored ? getV0() : getV1(), light);
    }

    private void makeCornerVertex(VertexConsumer pConsumer, Vector3f pVec3f, float p_233996_, float p_233997_, int p_233998_) {
        pConsumer.addVertex(pVec3f.x(), pVec3f.y(), pVec3f.z()).setUv(p_233996_, p_233997_).setColor(this.rCol, this.gCol, this.bCol, this.alpha).setLight(p_233998_);
    }

    public @NotNull ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    protected int getLightColor(float pPartialTick) {
        return 15728880;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<EnderThrustOptions> {
        private final SpriteSet sprite;

        public Provider(SpriteSet pSprite) {
            this.sprite = pSprite;
        }

        public Particle createParticle(@NotNull EnderThrustOptions options, @NotNull ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
            EnderThrust shriekparticle = new EnderThrust(pLevel, pX, pY, pZ, this.sprite, pXSpeed, pYSpeed, pZSpeed, options);
            shriekparticle.setSpriteFromAge(this.sprite);
            shriekparticle.setAlpha(1.0F);
            return shriekparticle;
        }
    }
}
