package com.northwestwind.slowpickmod.init;

import com.northwestwind.slowpickmod.SlowPick;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import java.util.function.Supplier;

@ObjectHolder(SlowPick.MOD_ID)
@Mod.EventBusSubscriber(modid = SlowPick.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemInit {
    public static final Item slow_pickaxe = new PickaxeItem(ModItemTier.SLOW, 2, 10.0f, new Item.Properties().group(SlowPick.SlowPickItemGroup.instance)).setRegistryName("slow_pickaxe");
    public static final Item slower_pickaxe = new PickaxeItem(ModItemTier.SLOWER, 3, 7.0f, new Item.Properties().group(SlowPick.SlowPickItemGroup.instance)).setRegistryName("slower_pickaxe");
    public static final Item slowest_pickaxe = new PickaxeItem(ModItemTier.SLOWEST, 4, 5.0f, new Item.Properties().group(SlowPick.SlowPickItemGroup.instance)).setRegistryName("slowest_pickaxe");

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        event.getRegistry().register(slow_pickaxe);
        event.getRegistry().register(slower_pickaxe);
        event.getRegistry().register(slowest_pickaxe);
    }

    private enum ModItemTier implements IItemTier {
        SLOW(3, 4200, 0.5f, 2.0f, 160, () -> Ingredient.EMPTY),
        SLOWER(4, 19881, 0.1f, 3.0f, 640, () -> Ingredient.EMPTY),
        SLOWEST(5, 69420, 0.05f, 4.0f, 2560, () -> Ingredient.EMPTY);

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final LazyValue<Ingredient> repairMaterial;

        ModItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
            this.harvestLevel = harvestLevelIn;
            this.maxUses = maxUsesIn;
            this.efficiency = efficiencyIn;
            this.attackDamage = attackDamageIn;
            this.enchantability = enchantabilityIn;
            this.repairMaterial = new LazyValue<>(repairMaterialIn);
        }

        public int getMaxUses() {
            return this.maxUses;
        }

        public float getEfficiency() {
            return this.efficiency;
        }

        public float getAttackDamage() {
            return this.attackDamage;
        }

        public int getHarvestLevel() {
            return this.harvestLevel;
        }

        public int getEnchantability() {
            return this.enchantability;
        }

        public Ingredient getRepairMaterial() {
            return this.repairMaterial.getValue();
        }
    }
}
