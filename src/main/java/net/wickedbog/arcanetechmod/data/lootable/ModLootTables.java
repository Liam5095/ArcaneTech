package net.wickedbog.arcanetechmod.data.lootable;

import com.google.common.collect.Sets;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.wickedbog.arcanetechmod.ArcaneTechMod;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ModLootTables extends LootTableProvider {
    public ModLootTables(PackOutput p_254123_) {
        super(p_254123_, Set.of(), List.of(new SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK)));
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationcontext) {
        var modLootTablesId = BuiltInLootTables.all()
                .stream()
                .filter(id -> id.getNamespace().equals(ArcaneTechMod.MOD_ID))
                .collect(Collectors.toSet());

        for (var id : Sets.difference(modLootTablesId, map.keySet())) {
            validationcontext.reportProblem("Missing mod loot table: " + id);
        }

        map.forEach((id, lootTable) -> lootTable.validate(validationcontext));
    }
}
