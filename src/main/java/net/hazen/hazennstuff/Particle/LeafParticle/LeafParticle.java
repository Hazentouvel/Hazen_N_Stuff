package net.hazen.hazennstuff.Particle.LeafParticle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

public class LeafParticle extends TextureSheetParticle {
    float targetR;
    float targetG;
    float targetB;
    int colorTime;
    boolean touchedGround;
    float bounciness;

    public LeafParticle(LeafParticleOptions options, ClientLevel level, double xCoord, double yCoord, double zCoord, double xd, double yd, double zd) {
        super(level, xCoord, yCoord, zCoord, xd, yd, zd);
        this.scale(this.random.nextFloat() * 0.15F + 0.1F);
        this.lifetime = 20 + (int)(Math.random() * (double)45.0F);
        this.gravity = 1.3F;
        this.friction = 0.985F;
        this.quadSize = 0.25F;
        this.targetR = options.color.x() * (0.9F + this.random.nextFloat() * 0.1F);
        this.targetG = options.color.y() * (0.9F + this.random.nextFloat() * 0.1F);
        this.targetB = options.color.z() * (0.9F + this.random.nextFloat() * 0.1F);
        this.bounciness = 0.6F + this.random.nextFloat() * 0.2F;
        this.colorTime = 5 + (int)(Math.random() * (double)20.0F);
        this.xd = xd;
        this.yd = yd;
        this.zd = zd;
    }

    public void tick() {
        if (!this.touchedGround && this.lifetime < 30) {
            ++this.lifetime;
        }

        float f = Mth.clamp((float)this.age / (float)this.colorTime, 0.0F, 1.0F);
        this.rCol = Mth.lerp(f, 1.0F, this.targetR);
        this.gCol = Mth.lerp(f, 1.0F, this.targetG);
        this.bCol = Mth.lerp(f, 1.0F, this.targetB);
        if (this.onGround) {
            this.touchedGround = true;
            this.yd *= (double)(-this.bounciness);
            this.bounciness *= 0.8F;
            this.quadSize *= 0.9F;
        }

        super.tick();
        if ((new Vec3(this.x - this.xo, this.y - this.yo, this.z - this.zo)).lengthSqr() < 0.001) {
            this.remove();
        }

    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public int getLightColor(float p_107564_) {
        return 15728880;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<LeafParticleOptions> {
        private final SpriteSet sprites;

        public Provider(SpriteSet spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(@NotNull LeafParticleOptions options, ClientLevel level, double x, double y, double z, double dx, double dy, double dz) {
            LeafParticle particle = new LeafParticle(options, level, x, y, z, dx, dy, dz);
            particle.pickSprite(this.sprites);
            return particle;
        }
    }
}
