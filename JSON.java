https://medium.com/@bubu.tripathy/json-serialization-and-deserialization-in-java-2a3f08266b70

@JsonIgnore - This annotation can be used to ignore a field during serialization and deserialization. Any field marked with this annotation will not be included in the JSON output or read from the JSON input.

@JsonProperty - This annotation can be used to specify the name of a field in the JSON output or input that differs from the name of the corresponding Java field. This can be useful when working with JSON data from external sources that use different naming conventions.

@JsonFormat: This annotation can be used to specify the format of a date or other value during serialization and deserialization. For example, you can use this annotation to specify that a date should be formatted as ISO-8601.

