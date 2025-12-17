package net.hazen.hazennstuff.Registries.Particle.SlashParticles.Spells.IonicSLash;

import com.mojang.blaze3d.vertex.VertexConsumer;
import io.redspace.ironsspellbooks.api.util.Utils;
import net.hazen.hazennstuff.Registries.HnSParticleHelper;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

public class IonicSlash extends TextureSheetParticle {
    private final SpriteSet sprites;
    private final Vec3 forward;
    private final boolean mirror;
    private final boolean vertical;
    private final Vector3f[] localVertices;

    IonicSlash(ClientLevel pLevel, double pX, double pY, double pZ, SpriteSet spriteSet, double xd, double yd, double zd, IonicSlashOptions options) {
        super(pLevel, pX, pY, pZ, (double)0.0F, (double)0.0F, (double)0.0F);
        this.xd = xd;
        this.yd = yd;
        this.zd = zd;
        this.lifetime = 4;
        this.gravity = 0.0F;
        this.sprites = spriteSet;
        this.quadSize = options.scale * 3.25F;
        this.forward = (new Vec3((double)options.xf, (double)options.yf, (double)options.zf)).normalize();
        this.mirror = options.mirror;
        this.vertical = options.vertical;
        this.localVertices = this.calculateVertices();
        this.friction = 1.0F;
    }

    private Vec3 vec3Copy(Vector3f vector3f) {
        return new Vec3((double)vector3f.x, (double)vector3f.y, (double)vector3f.z);
    }

    public void tick() {
        if (this.age == 0) {
            this.createBladeParticle();
        }

        if (this.age++ > this.lifetime) {
            this.remove();
        } else {
            this.setSpriteFromAge(this.sprites);
        }

    }

    private void createBladeParticle() {
        int particleCount = (int)(9.0F * this.quadSize);

        for(int i = 1; i < particleCount - 1; ++i) {
            float t = (float)i / (float)particleCount;
            float u = 1.0F - t;
            Vec3 localPos = this.vec3Copy(this.localVertices[1]).scale((double)(u * u * u)).add(this.vec3Copy(this.localVertices[2]).scale((double)(3.0F * u * u * t)).add(this.vec3Copy(this.localVertices[3]).scale((double)(3.0F * u * t * t)).add(this.vec3Copy(this.localVertices[0]).scale((double)(t * t * t))))).scale((double)(this.quadSize * 0.75F)).add(Utils.getRandomVec3(0.3));
            this.level.addParticle(HnSParticleHelper.BLADE_PARTICLE, this.x + localPos.x, this.y + localPos.y, this.z + localPos.z, (double)0.0F, (double)0.0F, (double)0.0F);
        }

    }

    private Vector3f[] calculateVertices() {
        boolean vertical = this.vertical;
        Vec3 forward = this.forward;
        Vec3 up = new Vec3((double)0.0F, (double)1.0F, (double)0.0F);
        if (forward.dot(up) > 0.999) {
            up = new Vec3((double)1.0F, (double)0.0F, (double)0.0F);
        }

        Vec3 right = forward.cross(up);
        up = up.subtract(this.proj(forward, up)).normalize();
        right = right.subtract(this.proj(forward, right)).subtract(this.proj(up, right)).normalize();
        Vec3 primary;
        Vec3 secondary;
        if (!vertical) {
            primary = forward;
            secondary = right;
        } else {
            primary = forward;
            secondary = up;
        }

        Vector3f[] vertices = new Vector3f[]{new Vector3f(-1.0F, -1.0F, 0.0F), new Vector3f(-1.0F, 1.0F, 0.0F), new Vector3f(1.0F, 1.0F, 0.0F), new Vector3f(1.0F, -1.0F, 0.0F)};

        for(int i = 0; i < 4; ++i) {
            float x = (float)(primary.x * (double)vertices[i].x + secondary.x * (double)vertices[i].y);
            float y = (float)(primary.y * (double)vertices[i].x + secondary.y * (double)vertices[i].y);
            float z = (float)(primary.z * (double)vertices[i].x + secondary.z * (double)vertices[i].y);
            vertices[i] = new Vector3f(x, y, z);
        }

        return vertices;
    }

    public Vec3 proj(Vec3 u, Vec3 v) {
        return u.scale(v.dot(u) / u.lengthSqr());
    }

    public void render(VertexConsumer buffer, Camera camera, float partialTick) {
        boolean mirrored = !this.mirror;
        Vec3 vec3 = camera.getPosition();
        float f = (float)(Mth.lerp((double)partialTick, this.xo, this.x) - vec3.x());
        float f1 = (float)(Mth.lerp((double)partialTick, this.yo, this.y) - vec3.y());
        float f2 = (float)(Mth.lerp((double)partialTick, this.zo, this.z) - vec3.z());
        Vector3f[] vertices = new Vector3f[4];

        for(int i = 0; i < 4; ++i) {
            Vector3f localVertex = this.localVertices[i];
            vertices[i] = new Vector3f(localVertex.x, localVertex.y, localVertex.z);
            vertices[i].mul(this.getQuadSize(partialTick));
            vertices[i].add(f, f1, f2);
        }

        int j = this.getLightColor(partialTick);
        this.makeCornerVertex(buffer, vertices[0], this.getU1(), mirrored ? this.getV0() : this.getV1(), j);
        this.makeCornerVertex(buffer, vertices[1], this.getU1(), mirrored ? this.getV1() : this.getV0(), j);
        this.makeCornerVertex(buffer, vertices[2], this.getU0(), mirrored ? this.getV1() : this.getV0(), j);
        this.makeCornerVertex(buffer, vertices[3], this.getU0(), mirrored ? this.getV0() : this.getV1(), j);
        this.makeCornerVertex(buffer, vertices[3], this.getU0(), mirrored ? this.getV0() : this.getV1(), j);
        this.makeCornerVertex(buffer, vertices[2], this.getU0(), mirrored ? this.getV1() : this.getV0(), j);
        this.makeCornerVertex(buffer, vertices[1], this.getU1(), mirrored ? this.getV1() : this.getV0(), j);
        this.makeCornerVertex(buffer, vertices[0], this.getU1(), mirrored ? this.getV0() : this.getV1(), j);
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
    public static class Provider implements ParticleProvider<IonicSlashOptions> {
        private final SpriteSet sprite;

        public Provider(SpriteSet pSprite) {
            this.sprite = pSprite;
        }

        public Particle createParticle(@NotNull IonicSlashOptions options, @NotNull ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
            IonicSlash shriekparticle = new IonicSlash(pLevel, pX, pY, pZ, this.sprite, pXSpeed, pYSpeed, pZSpeed, options);
            shriekparticle.setSpriteFromAge(this.sprite);
            shriekparticle.setAlpha(1.0F);
            return shriekparticle;
        }
    }
}
