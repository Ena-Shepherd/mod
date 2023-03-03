/*

 Author: Yannis STEFANELLI

 Creation Date: 18-02-2023 16:23:34

 Description :

*/

package ena.testmod.items;

import org.jetbrains.annotations.Nullable;

import eu.pb4.polymer.core.api.item.PolymerItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ExampleItem extends Item implements PolymerItem {

    public ExampleItem(Settings settings) {
        super(settings);
    }
    
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        playerEntity.playSound(SoundEvents.BLOCK_AMETHYST_BLOCK_BREAK, 1.0F, 1.0F);
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
    
///////////////////////////////////////////////////////
    
    //client method
    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getPolymerItem'");
        return Items.STICK;
    }
}
