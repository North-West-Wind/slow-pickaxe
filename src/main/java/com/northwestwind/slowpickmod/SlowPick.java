package com.northwestwind.slowpickmod;

import com.northwestwind.slowpickmod.init.ItemInit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SlowPick.MOD_ID)
public class SlowPick
{
    public static final String MOD_ID = "slowpickmod";

    public SlowPick() {
    }

    public static class SlowPickItemGroup extends ItemGroup {
        public static final ItemGroup instance = new SlowPickItemGroup(ItemGroup.GROUPS.length, "slowpicktab");

        private SlowPickItemGroup(int index, String label) {
            super(index, label);
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemInit.slow_pickaxe);
        }
    }
}
