package tripDemo.model.homework;

import java.util.List;
import lombok.Data;
import tripDemo.model.Category;
import tripDemo.model.homework.TagsItem;

@Data
public class Response{
	private List<String> photoUrls;
	private String name;
	private int id;
	private Category category;
	private List<TagsItem> tags;
	private String status;
}