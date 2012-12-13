package cc.ywxm.model;

import java.util.List;

public class Node
{
	private Integer id;
	private String text;
	private String state;
	private Menus attributes;
	private List<Node> children;
	private Boolean checked;

	public Node(Integer id, String text, String state)
	{
		super();
		this.id = id;
		this.text = text;
		this.state = state;
	}

	public Node(Integer id, String text, String state, Menus attributes)
	{
		super();
		this.id = id;
		this.text = text;
		this.state = state;
		this.attributes = attributes;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public Menus getAttributes()
	{
		return attributes;
	}

	public void setAttributes(Menus attributes)
	{
		this.attributes = attributes;
	}

	public List<Node> getChildren()
	{
		return children;
	}

	public void setChildren(List<Node> children)
	{
		this.children = children;
	}

	public Boolean getChecked()
	{
		return checked;
	}

	public void setChecked(Boolean checked)
	{
		this.checked = checked;
	}

}
