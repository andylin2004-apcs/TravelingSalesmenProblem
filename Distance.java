class Distance{
  private String start, end;
  private int distance;

  public Distance(String start, String end, int distance){
    this.start = start;
    this.end = end;
    this.distance = distance;
  }
  public String toString(){
    return this.start + " " + this.end + " " + this.distance;
  }
  public String start(){
    return this.start;
  }
  public String end(){
    return this.end;
  }
  public int distance(){
    return this.distance;
  }
}
