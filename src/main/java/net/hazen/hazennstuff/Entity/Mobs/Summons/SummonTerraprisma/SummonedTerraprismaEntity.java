package net.hazen.hazennstuff.Entity.Mobs.Summons.SummonTerraprisma;

import io.redspace.ironsspellbooks.entity.mobs.goals.melee.AttackAnimationData;
import io.redspace.ironsspellbooks.entity.mobs.wizards.GenericAnimatedWarlockAttackGoal;
import io.redspace.ironsspellbooks.entity.spells.summoned_weapons.SummonedWeaponEntity;
import io.redspace.ironsspellbooks.registries.EntityRegistry;
import java.util.List;

import net.hazen.hazennstuff.Registries.HnSEntityRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

public class SummonedTerraprismaEntity extends SummonedTerraprismicEntity {
    public static AttributeSupplier.Builder prepareAttributes() {
        return LivingEntity.createLivingAttributes()
                .add(Attributes.ATTACK_KNOCKBACK, 1.0F)
                .add(Attributes.ATTACK_DAMAGE, 5.0F)
                .add(Attributes.MAX_HEALTH, 25.0F)
                .add(Attributes.FOLLOW_RANGE, 40.0F)
                .add(Attributes.FLYING_SPEED, 2.5F)
                .add(Attributes.ENTITY_INTERACTION_RANGE, 4.0F)
                .add(Attributes.MOVEMENT_SPEED, 0.5F);
    }

    public SummonedTerraprismaEntity(EntityType<? extends PathfinderMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public SummonedTerraprismaEntity(Level level, LivingEntity owner) {
        this(HnSEntityRegistry.TERRAPRISMA.get(), level);
    }

    public GenericAnimatedWarlockAttackGoal<SummonedTerraprismaEntity> makeAttackGoal() {
        return (new GenericAnimatedWarlockAttackGoal(this,
                1.5F,
                0,
                20))
                .setMoveset(List.of(
                        new AttackAnimationData(40, "animation.terraprisma.swing_a", 15),
                        new AttackAnimationData(40, "animation.terraprisma.swing_b", 24, 28),
                        new AttackAnimationData(90, "animation.terraprisma.swing_barrage", 22, 28, 35, 42, 48, 58, 63, 66, 69, 75, 78, 81, 85 ),
                        new AttackAnimationData(30, "animation.terraprisma.down_slash", 21)
                ));
    }
}
