package io.github.hydrazinemc.oxidiser.mixin.player;

import io.github.hydrazinemc.oxidiser.event.item.ItemCraftEvent;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeUnlocker;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(CraftingResultInventory.class)
public abstract class CraftingResultInventoryMixin implements RecipeUnlocker {
	@Override
	public boolean shouldCraftRecipe(World world, ServerPlayerEntity player, Recipe<?> recipe) {

		var result = ItemCraftEvent.INSTANCE.call(new ItemCraftEvent.EventData(player, recipe));
		if (result) {
			return false;
		}

		// [VanillaCopy]
		if (recipe.isIgnoredInRecipeBook() || !world.getGameRules().getBoolean(GameRules.DO_LIMITED_CRAFTING) || player.getRecipeBook().contains(recipe)) {
			this.setLastRecipe(recipe);
			return true;
		} else {
			return false;
		}
	}
}
