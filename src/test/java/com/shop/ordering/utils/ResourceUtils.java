package com.shop.ordering.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ResourceUtils {

	public static String readContent(String resourceName) {
		try (var inputStream = org.springframework.util.ResourceUtils.class.getClassLoader().getResourceAsStream(resourceName)) {
			if (inputStream == null) {
				throw new RuntimeException(new FileNotFoundException(resourceName));
			}
			return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}