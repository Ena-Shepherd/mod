
package ena.testmod.items;

import org.jetbrains.annotations.Nullable;

import eu.pb4.polymer.core.api.item.PolymerItem;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class LightsaberItem extends Item implements PolymerItem {
    public LightsaberItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
    // Votre code pour lancer l'item ici
    ItemStack stack = player.getStackInHand(hand);
    if (!world.isClient) {
        stack.addEnchantment(Enchantments.LOYALTY, 3);
    // Créer une nouvelle instance de l'entité du trident
        TridentEntity trident = new TridentEntity(world, player, stack);
        Vec3d velocity = player.getRotationVec(1.0F);
        trident.setVelocity(velocity.x, velocity.y, velocity.z);
        trident.setYaw(player.getYaw(1.0F));
        trident.setPitch(player.getPitch(1.0F));
        // Ajouter l'entité à la scène
        world.spawnEntity(trident);
        // Enlever 1 de l'objet de la main de l'utilisateur
        stack.decrement(1);
    }
    return new TypedActionResult<>(ActionResult.SUCCESS, player.getStackInHand(hand));
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getPolymerItem'");

        return Items.TRIDENT;
    }
        
}
