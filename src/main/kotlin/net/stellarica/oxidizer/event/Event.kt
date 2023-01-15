package net.stellarica.oxidizer.event


/**
 * A callable, subscribable event.
 */
open class Event<T> {
	protected val listeners = mutableSetOf<Listener<T>>()

	/**
	 * Call all listeners subscribed to this event.
	 * @param data to be passed to the listeners.
	 * @return true if the event was cancelled
	 */
	fun call(data: T): Boolean {
		listeners.sortedBy { it.priority }.forEach {
			when (it.invoke(it, data)) {
				Result.STOP -> return false
				Result.CANCEL -> return true
				Result.CONTINUE -> {}
			}
		}
		return false
	}

	/**
	 * Create and register a new listener.
	 * @param invoke the function to call when this event is fired
	 * @param priority the priority of this listener. Lower runs first.
	 */
	fun listen(
		priority: Int,
		invoke: Listener<T>.(T) -> Result
	) =
		Listener(this, invoke, priority)

	/**
	 * Wrapper for a thing that subscribes to an [Event]
	 */
	class Listener<T>(
		/** The event this is listening to **/
		val event: Event<T>,
		/** The function called when this event is fired **/
		val invoke: Listener<T>.(T) -> Result,
		/** The priority of this listener. Lower runs first **/
		val priority: Int = 0
	) {
		init {
			event.listeners.add(this)
		}

		/** Unregister this listener from [event] */
		fun unregister() {
			event.listeners.remove(this)
		}
	}

	enum class Result {
		/** Continue on to the next listener */
		CONTINUE,

		/** Stop running the next listeners, but don't cancel the event */
		STOP,

		/** Stop running listeners and cancel the event */
		CANCEL
	}
}
