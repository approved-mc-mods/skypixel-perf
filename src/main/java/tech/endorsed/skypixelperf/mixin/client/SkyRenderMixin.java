package tech.endorsed.skypixelperf.mixin.client;

import net.minecraft.client.render.Camera;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public class SkyRenderMixin {

    @Inject(at = @At("HEAD"), method = "renderStars()V", cancellable = true)
    private void onRenderStars(CallbackInfo ci) {
        ci.cancel();
    }

    @Inject(at = @At("HEAD"), method = "renderSky(Lnet/minecraft/client/util/math/MatrixStack;Lorg/joml/Matrix4f;FLnet/minecraft/client/render/Camera;ZLjava/lang/Runnable;)V", cancellable = true)
    private void onRenderSkyMatrix(MatrixStack matrices, Matrix4f projectionMatrix, float tickDelta, Camera camera, boolean bl, Runnable runnable, CallbackInfo ci) {
        ci.cancel();
    }

    @Inject(at = @At("HEAD"), method = "renderEndSky", cancellable = true)
    private void onRenderEndSky(CallbackInfo ci) {
        ci.cancel();
    }

    @Inject(at = @At("HEAD"), method = "renderLightSky", cancellable = true)
    private void onRenderLightSky(CallbackInfo ci) {
        ci.cancel();
    }

    @Inject(at = @At("HEAD"), method = "renderDarkSky", cancellable = true)
    private void onRenderDarkSky(CallbackInfo ci) {
        ci.cancel();
    }


}
