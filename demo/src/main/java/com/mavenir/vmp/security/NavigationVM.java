/**
 *
 */
package com.mavenir.vmp.security;

/**
 * The Class NavigationVM.
 *
 * @author Vlatka, OptimIT
 */
public class NavigationVM {

	/** The find subscriber. */
	private boolean findSubscriber;

	/** The create subscriber. */
	private boolean createSubscriber;

	/** The edit subscriber. */
	private boolean editSubscriber;

	/** The delete subscriber. */
	private boolean deleteSubscriber;

	/** The settings. */
	private boolean settings;

	/** The about. */
	private boolean about;

	/** The merge. */
	private boolean merge;

	/** The split. */
	private boolean split;

	/** The voicemail. */
	private boolean voicemail;
	
	/** The bulk provisioning. */
	private boolean bulkProvisioning;

	/** The bulk provisioning. */
	private boolean bulletinDeposit;

	/** The bulk provisioning. */
	private boolean bulletinRetrieve;

	/** The bulk provisioning. */
	private boolean bulletinDelete;
	
	/** The single Recovery. */
	private boolean singleRecovery;
	
	/** The bulk Recovery. */
	private boolean bulkRecovery;
	
	/** The message Recovery. */
	private boolean messageRecovery;
	
	/** The relocation subscribers. */
	private boolean subscriberRelocation;
	
	/**
	 * Checks if is find subscriber.
	 *
	 * @return true, if is find subscriber
	 */
	public boolean isFindSubscriber() {
		return findSubscriber;
	}

	/**
	 * Sets the find subscriber.
	 *
	 * @param findSubscriber the new find subscriber
	 */
	public void setFindSubscriber(boolean findSubscriber) {
		this.findSubscriber = findSubscriber;
	}

	/**
	 * Checks if is creates the subscriber.
	 *
	 * @return true, if is creates the subscriber
	 */
	public boolean isCreateSubscriber() {
		return createSubscriber;
	}

	/**
	 * Sets the creates the subscriber.
	 *
	 * @param createSubscriber the new creates the subscriber
	 */
	public void setCreateSubscriber(boolean createSubscriber) {
		this.createSubscriber = createSubscriber;
	}

	/**
	 * Checks if is edits the subscriber.
	 *
	 * @return true, if is edits the subscriber
	 */
	public boolean isEditSubscriber() {
		return editSubscriber;
	}

	/**
	 * Sets the edits the subscriber.
	 *
	 * @param editSubscriber the new edits the subscriber
	 */
	public void setEditSubscriber(boolean editSubscriber) {
		this.editSubscriber = editSubscriber;
	}

	/**
	 * Checks if is delete subscriber.
	 *
	 * @return true, if is delete subscriber
	 */
	public boolean isDeleteSubscriber() {
		return deleteSubscriber;
	}

	/**
	 * Sets the delete subscriber.
	 *
	 * @param deleteSubscriber the new delete subscriber
	 */
	public void setDeleteSubscriber(boolean deleteSubscriber) {
		this.deleteSubscriber = deleteSubscriber;
	}

	/**
	 * Checks if is settings.
	 *
	 * @return true, if is settings
	 */
	public boolean isSettings() {
		return settings;
	}

	/**
	 * Sets the settings.
	 *
	 * @param settings the new settings
	 */
	public void setSettings(boolean settings) {
		this.settings = settings;
	}

	/**
	 * Checks if is about.
	 *
	 * @return true, if is about
	 */
	public boolean isAbout() {
		return about;
	}

	/**
	 * Sets the about.
	 *
	 * @param about the new about
	 */
	public void setAbout(boolean about) {
		this.about = about;
	}

	public boolean isMerge() {
		return merge;
	}

	public void setMerge(boolean merge) {
		this.merge = merge;
	}

	public boolean isSplit() {
		return split;
	}

	public void setSplit(boolean split) {
		this.split = split;
	}

	/**
	 * Returns voicemail value.
	 *
	 * @return the voicemail value.
	 */
	public boolean isVoicemail() {
		return voicemail;
	}

	/**
	 * Sets voicemail to given value.
	 *
	 * @param voicemail the voicemail to set
	 */
	public void setVoicemail(boolean voicemail) {
		this.voicemail = voicemail;
	}

	/**
	 * Returns bulkProvisioning value.
	 *
	 * @return the bulkProvisioning value.
	 */
	public boolean isBulkProvisioning() {
		return bulkProvisioning;
	}

	/**
	 * Sets bulkProvisioning to given value.
	 *
	 * @param bulkProvisioning the bulkProvisioning to set
	 */
	public void setBulkProvisioning(boolean bulkProvisioning) {
		this.bulkProvisioning = bulkProvisioning;
	}

	/**
	 * Returns bulletinDeposit value.
	 *
	 * @return the bulletinDeposit value.
	 */
	public boolean isBulletinDeposit() {
		return bulletinDeposit;
	}

	/**
	 * Sets bulletinDeposit to given value.
	 *
	 * @param bulletinDeposit the bulletinDeposit to set
	 */
	public void setBulletinDeposit(boolean bulletinDeposit) {
		this.bulletinDeposit = bulletinDeposit;
	}

	/**
	 * Returns bulletinRetrieve value.
	 *
	 * @return the bulletinRetrieve value.
	 */
	public boolean isBulletinRetrieve() {
		return bulletinRetrieve;
	}

	/**
	 * Sets bulletinRetrieve to given value.
	 *
	 * @param bulletinRetrieve the bulletinRetrieve to set
	 */
	public void setBulletinRetrieve(boolean bulletinRetrieve) {
		this.bulletinRetrieve = bulletinRetrieve;
	}

	/**
	 * Returns bulletinDelete value.
	 *
	 * @return the bulletinDelete value.
	 */
	public boolean isBulletinDelete() {
		return bulletinDelete;
	}

	/**
	 * Sets bulletinDelete to given value.
	 *
	 * @param bulletinDelete the bulletinDelete to set
	 */
	public void setBulletinDelete(boolean bulletinDelete) {
		this.bulletinDelete = bulletinDelete;
	}
	/**
	 * Returns singleRecovery value.
	 *
	 * @return the singleRecovery value.
	 */
	public boolean isSingleRecovery() {
		return singleRecovery;
	}

	/**
	 * Sets singleRecovery to given value.
	 *
	 * @param singleRecovery the singleRecovery to set
	 */
	public void setSingleRecovery(boolean singleRecovery) {
		this.singleRecovery = singleRecovery;
	}
	/**
	 * Returns bulkRecovery value.
	 *
	 * @return the bulkRecovery value.
	 */
	public boolean isBulkRecovery() {
		return bulkRecovery;
	}

	/**
	 * Sets bulkRecovery to given value.
	 *
	 * @param bulkRecovery the bulkRecovery to set
	 */
	public void setBulkRecovery(boolean bulkRecovery) {
		this.bulkRecovery = bulkRecovery;
	}
	
	/**
	 * Returns messageRecovery value.
	 *
	 * @return the messageRecovery value.
	 */
	public boolean isMessageRecovery() {
		return messageRecovery;
	}

	/**
	 * Sets messageRecovery to given value.
	 *
	 * @param messageRecovery the messageRecovery to set
	 */
	public void setMessageRecovery(boolean messageRecovery) {
		this.messageRecovery = messageRecovery;
	}

	/**
	 * Returns subscriberRelocation value.
	 *
	 * @return the subscriberRelocation value.
	 */
	public boolean isRelocationSubscriber() {
		return subscriberRelocation;
	}

	/**
	 * Sets subscriberRelocation to given value.
	 *
	 * @param subscriberRelocation the subscriberRelocation to set
	 */
	public void setSubscriberRelocation(boolean subscriberRelocation) {
		this.subscriberRelocation = subscriberRelocation;
	}

}
