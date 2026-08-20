package terrafored.modid;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.Monster;

import java.util.EnumSet;
import java.util.List;

public class HostileModHideGoal extends Goal {
    private final OstrichEntity ostrich;
    private final double radius;

    public HostileModHideGoal(OstrichEntity ostrich, double radius) {
        this.ostrich = ostrich;
        this.radius = radius;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        return hasHostileNearby(this.radius);
    }

    @Override
    public boolean canContinueToUse() {
        // slightly larger radius = hysteresis, stops flms icker at the boundary
        return hasHostileNearby(this.radius + 2.0D);
    }

    @Override
    public void start() {
        this.ostrich.setHiding(true);
        this.ostrich.getNavigation().stop();
    }

    @Override
    public void stop() {
        this.ostrich.setHiding(false);
    }

    private boolean hasHostileNearby(double r) {
        List<Monster> nearby = this.ostrich.level().getEntitiesOfClass(
                Monster.class,
                this.ostrich.getBoundingBox().inflate(r),
                m -> m.isAlive() && m.distanceToSqr(this.ostrich) <= r * r
        );
        return !nearby.isEmpty();
    }
}