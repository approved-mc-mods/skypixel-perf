package tech.endorsed.skypixelperf.mixin.client.accessor;

import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(EntityRenderDispatcher.class)
public interface EntityRenderDispatcherInvoker {
    @Invoker("renderHitbox")
    public static void invokeRenderHitbox(MatrixStack matrices, VertexConsumer vertices, Entity entity, float tickDelta) {
        throw new AssertionError();
    }
}