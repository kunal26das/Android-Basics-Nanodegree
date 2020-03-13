package kunal26das.newsapp.source.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class NewsResponse {

	@SerializedName("userTier")
	private String userTier;

	@SerializedName("total")
	private int total;

	@SerializedName("startIndex")
	private int startIndex;

	@SerializedName("pages")
	private int pages;

	@SerializedName("pageSize")
	private int pageSize;

	@SerializedName("orderBy")
	private String orderBy;

	@SerializedName("currentPage")
	private int currentPage;

	@SerializedName("results")
	private List<News> results;

	@SerializedName("status")
	private String status;

	public void setUserTier(String userTier){
		this.userTier = userTier;
	}

	public String getUserTier(){
		return userTier;
	}

	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	public void setStartIndex(int startIndex){
		this.startIndex = startIndex;
	}

	public int getStartIndex(){
		return startIndex;
	}

	public void setPages(int pages){
		this.pages = pages;
	}

	public int getPages(){
		return pages;
	}

	public void setPageSize(int pageSize){
		this.pageSize = pageSize;
	}

	public int getPageSize(){
		return pageSize;
	}

	public void setOrderBy(String orderBy){
		this.orderBy = orderBy;
	}

	public String getOrderBy(){
		return orderBy;
	}

	public void setCurrentPage(int currentPage){
		this.currentPage = currentPage;
	}

	public int getCurrentPage(){
		return currentPage;
	}

	public void setResults(List<News> results){
		this.results = results;
	}

	public List<News> getResults(){
		return results;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"userTier = '" + userTier + '\'' + 
			",total = '" + total + '\'' + 
			",startIndex = '" + startIndex + '\'' + 
			",pages = '" + pages + '\'' + 
			",pageSize = '" + pageSize + '\'' + 
			",orderBy = '" + orderBy + '\'' + 
			",currentPage = '" + currentPage + '\'' + 
			",results = '" + results + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}