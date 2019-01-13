package io.github.prospector.silk.util;

public enum ActionType {
	/**
	 * @value Simulate: pretend to interact and return what would be returned if actually attempted
	 * @value Execute: actually attempt interaction, affecting the container
	 */
	PERFORM, SIMULATE
}
