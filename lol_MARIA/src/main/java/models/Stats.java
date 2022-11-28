package models;

public class Stats {
	private Integer champion;
	private String stat_name;
	private Float stat_value;
	private Float modifier_per_level;

	public Integer getChampion() {
		return this.champion;
	}

	public void setChampion(Integer champion) {
		this.champion = champion;
	}

	public String getStat_name() {
		return this.stat_name;
	}

	public void setStat_name(String stat_name) {
		this.stat_name = stat_name;
	}

	public Float getStat_value() {
		return this.stat_value;
	}

	public void setStat_value(Float stat_value) {
		this.stat_value = stat_value;
	}

	public Float getModifier_per_level() {
		return this.modifier_per_level;
	}

	public void setModifier_per_level(Float modifier_per_level) {
		this.modifier_per_level = modifier_per_level;
	}

	
}

