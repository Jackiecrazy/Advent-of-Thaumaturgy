package com.Jackiecrazi.aoatc.researchesnrecipes;

import net.minecraft.item.ItemStack;
import net.nevermine.izer.Itemizer;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class RealmstoneInfu extends ResearchItem {
    public RealmstoneInfu(String key, String category, AspectList tags, int col, int row, int complex, ItemStack icon) {
        super(key, category, tags, col, row, complex, new ItemStack(Itemizer.RealmstoneLabricon));
    }

    private InfusionRecipeRealmstone recipe;

    @Override
    public ResearchItem setPages(ResearchPage... pages) {
        for(ResearchPage page : pages) {
            if(page.type == ResearchPage.PageType.INFUSION_CRAFTING
                    && page.recipe instanceof InfusionRecipeRealmstone) {
                recipe = (InfusionRecipeRealmstone) page.recipe;
            }
        }
        return super.setPages(pages);
    }
}
