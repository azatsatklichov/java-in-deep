package collection.baeldung.modernjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.ListUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.google.common.collect.ImmutableList;

//https://www.baeldung.com/java-immutable-list
public class ImmutableArrayList {

	@Test
	public void givenUsingTheJdk_whenUnmodifiableListIsCreated_thenNotModifiable() {
		Assertions.assertThrows(UnsupportedOperationException.class, () -> {
			List<String> list = new ArrayList<String>(Arrays.asList("one", "two", "three"));
			List<String> unmodifiableList = Collections.unmodifiableList(list);
			unmodifiableList.add("four");
		});
	}

	@Test
	public void givenUsingGuava_whenUnmodifiableListIsCreated_thenNotModifiable() {
		Assertions.assertThrows(UnsupportedOperationException.class, () -> {
			List<String> list = new ArrayList<String>(Arrays.asList("one", "two", "three"));
			List<String> unmodifiableList = ImmutableList.copyOf(list);
			unmodifiableList.add("four");
		});
	}

	@Test
	public void givenUsingCommonsCollections_whenUnmodifiableListIsCreated_thenNotModifiable() {
		Assertions.assertThrows(UnsupportedOperationException.class, () -> {
			List<String> list = new ArrayList<String>(Arrays.asList("one", "two", "three"));
			List<String> unmodifiableList = ListUtils.unmodifiableList(list);
			unmodifiableList.add("four");
		});
	}

}
