import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ArgumentMap {

	private final Map<String, String> map;

	/**
	 * Initializes this argument map.
	 */
	public ArgumentMap() {
		this.map = new HashMap<>();
	}

	/**
	 * Initializes this argument map and then parsers the arguments into
	 * flag/value pairs where possible. Some flags may not have associated values.
	 * If a flag is repeated, its value is overwritten.
	 *
	 * @param args
	 */
	public ArgumentMap(String[] args) {
		this();
		parse(args);
	}

	/**
	 * Parses the arguments into flag/value pairs where possible. Some flags may
	 * not have associated values. If a flag is repeated, its value is
	 * overwritten.
	 *
	 * @param args the command line arguments to parse
	 */
	public void parse(String[] args) {
		for(int i = 0; i < args.length; i++) {
			if(isFlag(args[i])) {
				if(i < args.length-1 && isValue(args[i+1])) {
					map.put(args[i], args[i+1]);
				} else {
					map.put(args[i], null);
				}
			}
		}
	}

	/**
	 * Determines whether the argument is a flag. Flags start with a dash "-"
	 * character, followed by at least one other non-whitespace character.
	 *
	 * @param arg the argument to test if its a flag
	 * @return {@code true} if the argument is a flag
	 *
	 * @see String#startsWith(String)
	 * @see String#trim()
	 * @see String#isEmpty()
	 * @see String#length()
	 */
	public static boolean isFlag(String arg) {
		if(arg == null) {
			return false;
		}
		arg = arg.trim();
		return (arg.length() > 1 && arg.charAt(0) == '-');
	}

	/**
	 * Determines whether the argument is a value. Values do not start with a dash
	 * "-" character, and must consist of at least one non-whitespace character.
	 *
	 * @param arg the argument to test if its a value
	 * @return {@code true} if the argument is a value
	 *
	 * @see String#startsWith(String)
	 * @see String#trim()
	 * @see String#isEmpty()
	 * @see String#length()
	 */
	public static boolean isValue(String arg) {
		if(arg == null) {
			return false;
		}
		return (!arg.trim().isEmpty() && !arg.startsWith("-"));
	}

	/**
	 * Returns the number of unique flags.
	 *
	 * @return number of unique flags
	 */
	public int numFlags() {
		return map.size();
	}

	/**
	 * Determines whether the specified flag exists.
	 *
	 * @param flag the flag to search for
	 * @return {@code true} if the flag exists
	 */
	public boolean hasFlag(String flag) {
		return map.containsKey(flag);
	}

	/**
	 * Determines whether the specified flag is mapped to a non-null value.
	 *
	 * @param flag the flag to search for
	 * @return {@code true} if the flag is mapped to a non-null value
	 */
	public boolean hasValue(String flag) {
		return map.get(flag) != null;
	}

	/**
	 * Returns the value to which the specified flag is mapped as a
	 * {@link String}, or null if there is no mapping for the flag.
	 *
	 * @param flag the flag whose associated value is to be returned
	 * @return the value to which the specified flag is mapped, or {@code null} if
	 *         there is no mapping for the flag
	 */
	public String getString(String flag) {
		return map.get(flag);
	}

	/**
	 * Returns the value to which the specified flag is mapped as a
	 * {@link String}, or the default value if there is no mapping for the flag.
	 *
	 * @param flag         the flag whose associated value is to be returned
	 * @param defaultValue the default value to return if there is no mapping for
	 *                     the flag
	 * @return the value to which the specified flag is mapped, or the default
	 *         value if there is no mapping for the flag
	 */
	public String getString(String flag, String defaultValue) {
		String value = map.getOrDefault(flag, defaultValue);
		if(value == null) {
			return defaultValue;
		}
		return value;
	}

	/**
	 * Returns the value to which the specified flag is mapped as a {@link Path},
	 * or {@code null} if unable to retrieve this mapping for any reason
	 * (including being unable to convert the value to a {@link Path} or no value
	 * existing for this flag).
	 *
	 * This method should not throw any exceptions!
	 *
	 * @param flag the flag whose associated value is to be returned
	 * @return the value to which the specified flag is mapped, or {@code null} if
	 *         unable to retrieve this mapping for any reason
	 *
	 * @see Paths#get(String, String...)
	 */
	public Path getPath(String flag) {
		if(map.get(flag) != null) {
			return Paths.get(map.get(flag));
		} else {
			return null;
		}
	}

	/**
	 * Returns the value to which the specified flag is mapped as a {@link Path},
	 * or the default value if unable to retrieve this mapping for any reason
	 * (including being unable to convert the value to a {@link Path} or no value
	 * existing for this flag).
	 *
	 * This method should not throw any exceptions!
	 *
	 * @param flag         the flag whose associated value is to be returned
	 * @param defaultValue the default value to return if there is no mapping for
	 *                     the flag
	 * @return the value to which the specified flag is mapped as a {@link Path},
	 *         or the default value if there is no mapping for the flag
	 */
	public Path getPath(String flag, Path defaultValue) {
		if(map.containsKey(flag)) {
			if(map.get(flag) == null) {
				return defaultValue;
			} else {
				return Paths.get(map.get(flag));
			}
		} else {
			return defaultValue;
		}
	}
	
	/**
	 * Returns the value for the specified flag as an int value. If the flag is
	 * missing or the flag does not have a value, returns the specified default
	 * value instead.
	 *
	 * @param flag
	 *            flag to get value for
	 * @param defaultValue
	 *            value to return if the flag or value is missing
	 * @return value of flag as an int, or the default value if the flag or
	 *         value is missing
	 */
	public int getInteger(String flag, int defaultValue) {
		if(!hasFlag(flag)) {
			return defaultValue;
		}else if(!hasValue(flag)) {
			return defaultValue;
		}else {
			try{
				return Integer.parseInt(getString(flag));
			} catch (Exception e){
				return defaultValue;
			}
		}
	}

	@Override
	public String toString() {
		return this.map.toString();
	}
}
