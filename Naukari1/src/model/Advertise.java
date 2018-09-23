package model;

public class Advertise {
  String addId;
  String title;
  String about;
  String posts;
  String payscale;
  
  public Advertise(String title, String about, String posts, String payscale, String qualification, String agelimit, String apply, String note, String startDate, String endDate, String aboutlink, String location, String applicationfees, String authorisedwebsite, String selectionproccess, String pdflink, String youtubelink, String image) { this.title = title;
    this.about = about;
    this.posts = posts;
    this.payscale = payscale;
    this.qualification = qualification;
    this.agelimit = agelimit;
    this.apply = apply;
    this.note = note;
    this.startDate = startDate;
    this.endDate = endDate;
    this.aboutlink = aboutlink;
    this.location = location;
    this.applicationfees = applicationfees;
    this.authorisedwebsite = authorisedwebsite;
    this.selectionproccess = selectionproccess;
    this.pdflink = pdflink;
    this.youtubelink = youtubelink;
    this.image = image; }
  
  String qualification;
  String agelimit;
  String apply;
  String note;
  String startDate;
  
  public Advertise() {}
  
  public String getUpdateDate() { return updateDate; }
  
  public void setUpdateDate(String updateDate)
  {
    this.updateDate = updateDate;
  }
  

  public String getAddId() { return addId; }
  
  String endDate;
  
  public void setAddId(String addId) { this.addId = addId; }
  
  String aboutlink;
  String location;
  String applicationfees;
  
  public String getTitle() { return title; }
  
  String authorisedwebsite;
  String selectionproccess;
  
  public void setTitle(String title) { this.title = title; }
  
  String pdflink;
  
  public String getAbout() { return about; }
  
  String youtubelink;
  
  public void setAbout(String about) { this.about = about; }
  
  String updateDate;
  String image;
  public String getPosts() { return posts; }
  
  public void setPosts(String posts)
  {
    this.posts = posts;
  }
  
  public String getPayscale() {
    return payscale;
  }
  
  public void setPayscale(String payscale) {
    this.payscale = payscale;
  }
  
  public String getQualification() {
    return qualification;
  }
  
  public void setQualification(String qualification) {
    this.qualification = qualification;
  }
  
  public String getAgelimit() {
    return agelimit;
  }
  
  public void setAgelimit(String agelimit) {
    this.agelimit = agelimit;
  }
  
  public String getApply() {
    return apply;
  }
  
  public void setApply(String apply) {
    this.apply = apply;
  }
  
  public String getNote() {
    return note;
  }
  
  public void setNote(String note) {
    this.note = note;
  }
  
  public String getStartDate() {
    return startDate;
  }
  
  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }
  
  public String getEndDate() {
    return endDate;
  }
  
  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }
  
  public String getAboutlink() {
    return aboutlink;
  }
  
  public void setAboutlink(String aboutlink) {
    this.aboutlink = aboutlink;
  }
  
  public String getLocation() {
    return location;
  }
  
  public void setLocation(String location) {
    this.location = location;
  }
  
  public String getApplicationfees() {
    return applicationfees;
  }
  
  public void setApplicationfees(String applicationfees) {
    this.applicationfees = applicationfees;
  }
  
  public String getAuthorisedwebsite() {
    return authorisedwebsite;
  }
  
  public void setAuthorisedwebsite(String authorisedwebsite) {
    this.authorisedwebsite = authorisedwebsite;
  }
  
  public String getSelectionproccess() {
    return selectionproccess;
  }
  
  public void setSelectionproccess(String selectionproccess) {
    this.selectionproccess = selectionproccess;
  }
  
  public String getPdflink() {
    return pdflink;
  }
  
  public void setPdflink(String pdflink) {
    this.pdflink = pdflink;
  }
  
  public String getYoutubelink() {
    return youtubelink;
  }
  
  public void setYoutubelink(String youtubelink) {
    this.youtubelink = youtubelink;
  }
  
  public String getImage() {
    return image;
  }
  
  public void setImage(String image) {
    this.image = image;
  }
  
  public String toString()
  {
    return "SubmitAdd{title=" + title + ", about=" + about + ", posts=" + posts + ", payscale=" + payscale + ", qualification=" + qualification + ", agelimit=" + agelimit + ", apply=" + apply + ", note=" + note + ", startdate=" + startDate + ", enddate=" + endDate + ", aboutlink=" + aboutlink + ", location=" + location + ", applicationfees=" + applicationfees + ", authorisedwebsite=" + authorisedwebsite + ", selectionproccess=" + selectionproccess + ", pdflink=" + pdflink + ", youtubelink=" + youtubelink + ", image=" + image + '}';
  }
}