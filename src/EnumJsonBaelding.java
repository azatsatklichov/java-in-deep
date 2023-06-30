package net.sahet.utils;

/**
 * JSON Representation of Enum Using Jackson libraries, it's possible to have a
 * JSON representation of enum types as if they're POJOs. In the code snippet
 * below, we'll see how we can use the Jackson annotations for the same:
 * 
 * <pre>
 * We can use the Pizza and PizzaStatus as follows:

Pizza pz = new Pizza();
pz.setStatus(Pizza.PizzaStatusJson.READY);
System.out.println(Pizza.getJsonString(pz));
Copy
This will generate the following JSON representation of the Pizzas status:

{
  "status" : {
    "timeToDelivery" : 2,
    "ready" : true,
    "ordered" : false,
    "delivered" : false
  },
  "deliverable" : true
}
 * </pre>
 */
//@JsonFormat(shape = JsonFormat.Shape.OBJECT) //enable this 
enum PizzaStatusJson { // public
	ORDERED(5) {
		@Override
		public boolean isOrdered() {
			return true;
		}
	},
	READY(2) {
		@Override
		public boolean isReady() {
			return true;
		}
	},
	DELIVERED(0) {
		@Override
		public boolean isDelivered() {
			return true;
		}
	};

	private int timeToDelivery;

	public boolean isOrdered() {
		return false;
	}

	public boolean isReady() {
		return false;
	}

	public boolean isDelivered() {
		return false;
	}

	// @JsonProperty("timeToDelivery")
	public int getTimeToDelivery() {
		return timeToDelivery;
	}

	private PizzaStatusJson(int timeToDelivery) {
		this.timeToDelivery = timeToDelivery;
	}
}
