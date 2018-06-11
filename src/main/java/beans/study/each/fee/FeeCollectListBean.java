package beans.study.each.fee;

public class FeeCollectListBean {
	
	public static final String QUERY_GET = "SELECT m_name, fm_fee, fm_note FROM feeMember, member WHERE m_index = fm_m_index AND fm_mt_id = ?";
	
	private String memberName;
	private int fee;
	private String note;
	
	public String getMemberName() {
		return memberName;
	}
	public int getFee() {
		return fee;
	}
	public String getNote() {
		return note;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
}
