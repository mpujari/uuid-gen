package com.uuid;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.fasterxml.uuid.UUIDType;
import com.fasterxml.uuid.impl.NameBasedGenerator;

/**
 * Hello world!
 *
 */
public class App {
	static final NameBasedGenerator UUIDGEN;

	static {
		try {
			UUIDGEN = new NameBasedGenerator(NameBasedGenerator.NAMESPACE_DNS, MessageDigest.getInstance("SHA-1"),
					UUIDType.NAME_BASED_SHA1);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Please provide a valid input string to generate the UUID");
		} else {
			for(int i = 0; i < args.length; i++) {
				System.out.println(uuidv5(args[i]));
			}
		}
	}

	public static String uuidv5(String str) {
		return UUIDGEN.generate(str).toString();
	}

}
