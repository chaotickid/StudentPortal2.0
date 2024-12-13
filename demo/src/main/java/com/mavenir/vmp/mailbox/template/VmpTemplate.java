/**
 *
 */
package com.mavenir.vmp.mailbox.template;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Vlatka, OptimIT
 *
 */
public class VmpTemplate {

	/** The id. */
	private String id;

	/** The description. */
	private String description;

	/** The properties. */
	private List<VmpTemplateEntry> properties;

	/** The map properties. */
	private Map<String, String> propertiesMap;

	/**
	 * Gets the property value.
	 *
	 * @param key the key
	 * @return the property value
	 */
	public String getPropertyValue(String key) {
		return getPropertiesMap().get(key);
	}

	/**
	 * Gets the property keys.
	 *
	 * @return the property keys
	 */
	public Set<String> getPropertyKeys() {
		return getPropertiesMap().keySet();
	}

	public boolean containsKey(String key) {
		return getPropertiesMap().containsKey(key);
	}

	/**
	 * Gets the properties.
	 *
	 * @return the properties
	 */
	public Map<String, String> getPropertiesMap() {
		if (this.propertiesMap == null) {
			this.propertiesMap = new HashMap<String, String>();
			for (VmpTemplateEntry entry : this.getProperties()) {
				this.propertiesMap.put(entry.getKey(), entry.getValue());
			}
		}
		return this.propertiesMap;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the properties.
	 *
	 * @return the properties
	 */
	public List<VmpTemplateEntry> getProperties() {
		return properties;
	}

	/**
	 * Sets the properties.
	 *
	 * @param properties the new properties
	 */
	public void setProperties(List<VmpTemplateEntry> properties) {
		this.properties = properties;
	}

	public static class VmpTemplateEntry {

		/** The key. */
		private String key;

		/** The value. */
		private String value;

		/**
		 * Gets the key.
		 *
		 * @return the key
		 */
		public String getKey() {
			return key;
		}

		/**
		 * Sets the key.
		 *
		 * @param key the new key
		 */
		public void setKey(String key) {
			this.key = key;
		}

		/**
		 * Gets the value.
		 *
		 * @return the value
		 */
		public String getValue() {
			return value;
		}

		/**
		 * Sets the value.
		 *
		 * @param value the new value
		 */
		public void setValue(String value) {
			this.value = value;
		}

	}

}
