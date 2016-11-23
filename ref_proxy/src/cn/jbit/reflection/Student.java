package cn.jbit.reflection;
class Student {
	String name;
	int age;
	float score;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public Student(String name, int age, float score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
	}

	public Student() {
		super();
	}

	public String toString() {
		return name + age + score;
	}
}