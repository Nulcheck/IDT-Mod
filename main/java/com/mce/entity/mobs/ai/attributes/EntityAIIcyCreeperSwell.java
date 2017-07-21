package com.mce.entity.mobs.ai.attributes;

import com.mce.entity.mobs.EntityIcyCreeper;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAIIcyCreeperSwell extends EntityAIBase {
	/** The creeper that is swelling. */
	EntityIcyCreeper swellingCreeper;
	EntityLivingBase creeperAttackTarget;
	private static final String __OBFID = "CL_00001614";

	public EntityAIIcyCreeperSwell(EntityIcyCreeper entity) {
		this.swellingCreeper = entity;
		this.setMutexBits(1);
	}

	/**
	 * Returns whether the EntityAIBase should begin execution.
	 */
	public boolean shouldExecute() {
		EntityLivingBase entitylivingbase = this.swellingCreeper.getAttackTarget();
		return this.swellingCreeper.getCreeperState() > 0
				|| entitylivingbase != null && this.swellingCreeper.getDistanceSqToEntity(entitylivingbase) < 9.0D;
	}

	/**
	 * Execute a one shot task or start executing a continuous task
	 */
	public void startExecuting() {
		this.swellingCreeper.getNavigator().clearPathEntity();
		this.creeperAttackTarget = this.swellingCreeper.getAttackTarget();
	}

	/**
	 * Resets the task
	 */
	public void resetTask() {
		this.creeperAttackTarget = null;
	}

	/**
	 * Updates the task
	 */
	public void updateTask() {
		if (this.creeperAttackTarget == null) {
			this.swellingCreeper.setCreeperState(-1);
		} else if (this.swellingCreeper.getDistanceSqToEntity(this.creeperAttackTarget) > 49.0D) {
			this.swellingCreeper.setCreeperState(-1);
		} else if (!this.swellingCreeper.getEntitySenses().canSee(this.creeperAttackTarget)) {
			this.swellingCreeper.setCreeperState(-1);
		} else {
			this.swellingCreeper.setCreeperState(1);
		}
	}
}