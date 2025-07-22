package beetrap.btfmc.mixin.client;

import beetrap.btfmc.ClientGlowingEntityManager;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class GlowingEntityClientMixin {

    @Inject(method = "isGlowing", at = @At("HEAD"), cancellable = true)
    private void modifyGlowing(CallbackInfoReturnable<Boolean> cir) {
        if(ClientGlowingEntityManager.shouldGlow((Entity)(Object)this)) {
            cir.setReturnValue(true);
        }
    }
}