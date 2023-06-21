package tech.endorsed.skypixelperf.mixin.client;


import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.resource.SynchronousResourceReloader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import tech.endorsed.skypixelperf.mixin.client.accessor.EntityRenderDispatcherInvoker;

/**
 * Removes entity rendering when showing hitboxes
 */
@Mixin(EntityRenderDispatcher.class)
public abstract class EntityRendererMixin implements SynchronousResourceReloader {
    @Shadow
    boolean renderHitboxes;

    @Inject(at = @At(value = "INVOKE", target="Lnet/minecraft/client/render/entity/EntityRenderer;render(Lnet/minecraft/entity/Entity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"), method = "render", cancellable = true)
    private <E extends Entity> void render(E entity, double x, double y, double z, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, CallbackInfo ci) {
        if (this.renderHitboxes) {
            EntityRenderDispatcherInvoker.invokeRenderHitbox(matrices, vertexConsumers.getBuffer(RenderLayer.getLines()), entity, tickDelta);
            matrices.pop();
            ci.cancel();
        }
    }
}
