package org.demo.monolithic_shop_app.business_module.sale_and_marketing;

import java.util.HashMap;
import java.util.List;

public class SurveyDetail {
	
	private String surveyDetailId;
	private String surveyId;
	private List<String> questionList;
	private List<HashMap<String, String>> answerDataList;
	private List<String> userChoiceList;
	
	public SurveyDetail() {}
	
	public SurveyDetail(String surveyDetailId, String surveyId, List<String> questionList, List<HashMap<String, String>> answerDataList
						, List<String> userChoiceList) {
		this.surveyDetailId = surveyDetailId;
		this.surveyId = surveyId;
		this.questionList = questionList;
		this.answerDataList = answerDataList;
		this.userChoiceList = userChoiceList;
	}
	
	public String getSurveyDetailId() {
		return surveyDetailId;
	}
	public void setSurveyDetailId(String surveyDetailId) {
		this.surveyDetailId = surveyDetailId;
	}
	public String getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(String surveyId) {
		this.surveyId = surveyId;
	}
	public List<String> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(List<String> questionList) {
		this.questionList = questionList;
	}
	public List<HashMap<String, String>> getAnswerDataList() {
		return answerDataList;
	}
	public void setAnswerDataList(List<HashMap<String, String>> answerDataList) {
		this.answerDataList = answerDataList;
	}
	public List<String> getUserChoiceList() {
		return userChoiceList;
	}
	public void setUserChoiceList(List<String> userChoiceList) {
		this.userChoiceList = userChoiceList;
	}

}
