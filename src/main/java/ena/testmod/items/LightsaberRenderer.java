// package ena.testmod.items;

// import net.minecraft.client.MinecraftClient;
// import net.minecraft.client.color.item.ItemColors;
// import net.minecraft.client.render.VertexConsumerProvider;
// import net.minecraft.client.render.item.BuiltinModelItemRenderer;
// import net.minecraft.client.render.item.ItemRenderer;
// import net.minecraft.client.render.model.BakedModel;
// import net.minecraft.client.render.model.BakedModelManager;
// import net.minecraft.client.render.model.json.ModelTransformation;
// import net.minecraft.client.texture.TextureManager;
// import net.minecraft.client.util.ModelIdentifier;
// import net.minecraft.client.util.math.MatrixStack;
// import net.minecraft.item.ItemStack;
// import net.minecraft.util.Identifier;
// import net.minecraft.util.Identifier.ExtraData;

// public class LightsaberRenderer<ExtraData> extends ItemRenderer {
//     private final MinecraftClient client;
//     private final BakedModelManager modelManager;
    
//     public LightsaberRenderer(TextureManager manager, BakedModelManager bakery, ItemColors colors,
//         BuiltinModelItemRenderer builtinModelItemRenderer) {
//             super(manager, bakery, colors, builtinModelItemRenderer);
//             this.client = MinecraftClient.getInstance();
//             this.modelManager = bakery;
//         }

//     @Override
//     public void renderItem(net.minecraft.item.ItemStack stack, net.minecraft.client.render.model.json.ModelTransformation.Mode renderMode, boolean leftHanded, net.minecraft.client.util.math.MatrixStack matrices, net.minecraft.client.render.VertexConsumerProvider vertexConsumers, int light, int overlay, net.minecraft.client.render.model.BakedModel model) {
//         if(stack.isEmpty()) {
//            return;
//         }
//     }
  
//         // matrices.push();
//         BakedModel model = modelManager.getModel(new ModelIdentifier("minecraft", "lightsaber", "inventory", (ExtraData) new Identifier(null)));
//         super.renderItem(stack, renderMode, leftHanded, matrices, vertexConsumers, light, overlay, model);
//         matrices.pop();
//     }
// }

//ClientRegistry.bindTileEntityRenderer(LightsaberRenderer.class, LightsaberRenderer::new);
