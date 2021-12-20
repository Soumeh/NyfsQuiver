package com.nyfaria.nyfsquiver.mixin;

import com.nyfaria.nyfsquiver.cap.QuiverHolder;
import com.nyfaria.nyfsquiver.cap.QuiverHolderAttacher;
import com.nyfaria.nyfsquiver.init.TagInit;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.AbstractArrow.Pickup;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import com.nyfaria.nyfsquiver.NyfsQuiver;
import com.nyfaria.nyfsquiver.items.QuiverInventory;
import com.nyfaria.nyfsquiver.items.QuiverItem;
import com.nyfaria.nyfsquiver.items.QuiverStorageManager;

import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;
import top.theillusivec4.curios.api.type.inventory.ICurioStacksHandler;


@Mixin(AbstractArrow.class)
public abstract class ArrowEntityMixin extends Projectile
{

	@Shadow
	protected boolean inGround;

	protected ArrowEntityMixin(EntityType<? extends Projectile> p_37248_, Level p_37249_) {
		super(p_37248_, p_37249_);
	}

	@Shadow
	protected abstract ItemStack getPickupItem();


	@Shadow public abstract boolean isNoPhysics();

	@Shadow public int shakeTime;

	@Shadow public AbstractArrow.Pickup pickup;

	/**
	 * @author
	 */
	@Overwrite
	public void playerTouch(Player player)
	{
		
	      if (this.pickup == Pickup.ALLOWED && !level.isClientSide && (this.inGround || this.isNoPhysics()) && this.shakeTime <= 0) {
	    	  boolean flag;
	    	  ItemStack quiverStack = CuriosApi.getCuriosHelper().findEquippedCurio(item -> item.getItem() instanceof QuiverItem,player)
					.map(stringIntegerItemStackImmutableTriple -> stringIntegerItemStackImmutableTriple.right).orElse(ItemStack.EMPTY);
			  if(!quiverStack.isEmpty()) {
				  ItemStack stack = QuiverHolderAttacher.getQuiverHolderUnwrap(quiverStack).getInventory().getStackInSlot(quiverStack.getOrCreateTag().getInt(""));
				  if (stack.getItem() == this.getPickupItem().getItem() && stack.getCount() < 64 && !quiverStack.isEmpty()) {
					  stack.setCount(stack.getCount() + 1);
					  this.remove(RemovalReason.DISCARDED);
					  return;
				  }

				  if ((this.getPickupItem().is(TagInit.QUIVER_ITEMS)) && !quiverStack.isEmpty()) {
					  QuiverInventory boop = QuiverItem.getInventory(quiverStack);
					  for (int i = 0; i < boop.getSlots(); i++) {
						  if (boop.getStackInSlot(i).getItem() == this.getPickupItem().getItem() && boop.getStackInSlot(i).getCount() < 64) {
							  boop.getStackInSlot(i).setCount(boop.getStackInSlot(i).getCount() + 1);
							  this.remove(RemovalReason.DISCARDED);
							  return;
						  }

						  if (boop.getStackInSlot(i).isEmpty()) {
							  boop.setStackInSlot(i, this.getPickupItem());
							  this.remove(RemovalReason.DISCARDED);
							  return;
						  }
					  }
				  }
			  }
	    	  flag = (this.pickup == Pickup.ALLOWED ||
	    			  this.pickup == Pickup.CREATIVE_ONLY
	    			  && player.getAbilities().instabuild || this.isNoPhysics() &&
	    			  this.getOwner().getUUID() == player.getUUID());
	    	  if (this.pickup == Pickup.ALLOWED
	    			  && !player.getInventory().add(this.getPickupItem())) {
	    		  flag = false;
	    	  }
	    	  
	    	  if (flag) {
	    		  player.take(this, 1);
	    		  this.remove(RemovalReason.DISCARDED);
	    	  }

	      }

	}

}