package qaautomation.july2022.utils;

public class GraphQLRequestBuilder {
	public org.json.JSONObject json;

	public GraphQLRequestBuilder() {
		json = new org.json.JSONObject();
	}

	public void setQuery(String query) {
		json.put("query", query);
	}

	public void setVariable(String variable) {
		json.put("variable", variable);
	}

	public String getJSONString() {
		return json.toString();
	}

}
