package com.shnupbups.golemhealer;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;

import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.ActionResult;

@SuppressWarnings("unused")
public class GolemHealer implements ModInitializer {
	@Override
	public void onInitialize() {
		UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			if(!player.isSpectator()) {
				if(entity instanceof IronGolemEntity) {
					if(!player.getStackInHand(hand).isEmpty()) {
						ItemStack stack = player.getStackInHand(hand);
						IronGolemEntity golem = (IronGolemEntity)entity;
						if(stack.getItem() == Items.IRON_INGOT && golem.getHealth()<golem.getHealthMaximum()) {
							golem.heal(10.0f);
							for(int int_1 = 0; int_1 < 7; ++int_1) {
								double double_1 = world.random.nextGaussian() * 0.02D;
								double double_2 = world.random.nextGaussian() * 0.02D;
								double double_3 = world.random.nextGaussian() * 0.02D;
								world.addParticle(ParticleTypes.HEART, golem.x + (double)(world.random.nextFloat() * golem.getWidth() * 2.0F) - (double)golem.getWidth(), golem.y + 0.5D + (double)(world.random.nextFloat() * golem.getHeight()), golem.z + (double)(world.random.nextFloat() * golem.getWidth() * 2.0F) - (double)golem.getWidth(), double_1, double_2, double_3);
							}
							if(!player.isCreative()) stack.decrement(1);
							return ActionResult.SUCCESS;
						}
					}
				} else if(entity instanceof SnowGolemEntity) {
					if(!player.getStackInHand(hand).isEmpty()) {
						ItemStack stack = player.getStackInHand(hand);
						SnowGolemEntity golem = (SnowGolemEntity)entity;
						if(stack.getItem() == Items.SNOWBALL && golem.getHealth()<golem.getHealthMaximum()) {
							golem.heal(1.0f);
							for(int int_1 = 0; int_1 < 7; ++int_1) {
								double double_1 = world.random.nextGaussian() * 0.02D;
								double double_2 = world.random.nextGaussian() * 0.02D;
								double double_3 = world.random.nextGaussian() * 0.02D;
								world.addParticle(ParticleTypes.HEART, golem.x + (double)(world.random.nextFloat() * golem.getWidth() * 2.0F) - (double)golem.getWidth(), golem.y + 0.5D + (double)(world.random.nextFloat() * golem.getHeight()), golem.z + (double)(world.random.nextFloat() * golem.getWidth() * 2.0F) - (double)golem.getWidth(), double_1, double_2, double_3);
							}
							if(!player.isCreative()) stack.decrement(1);
							return ActionResult.SUCCESS;
						}
					}
				}
			}
			return ActionResult.PASS;
		});
	}
}
