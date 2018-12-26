package service;

import domain.MemberBean;

public class MemberServiceImpl implements MemberService{
	private int count,same;
	private MemberBean[] members;
	
	public MemberServiceImpl() {
		count = 0; 
		same = 0;
		members = new MemberBean[10];
	}

	@Override
	public MemberBean createMember(String id, String pass, String name, String ssn) {
		MemberBean bean = new MemberBean();
		bean.setId(id);
		bean.setName(name);
		bean.setPass(pass);
		bean.setSsn(ssn);
		members[count] = bean;
		count++;
		return null;
	}

	@Override
	public MemberBean[] findAll() {
		return members;
	}

	@Override
	public MemberBean[] findName(String name) {
		for(int i=0;i<count;i++) {
			if(members[i].getName().equals(name)) {
				same++;
			}
		}
		MemberBean[] bean = new MemberBean[same];
		
		for(int i=0,j=0;i<count;i++) {
			if(members[i].getName().equals(name)) {
				bean[j] = members[i];
				j++;
			}
		}
		return bean;
	}

	@Override
	public MemberBean findId(String id) {
		MemberBean bean = new MemberBean();
		for(int i=0;i<count;i++) {
			if(members[i].getId().equals(id)) {
				bean = members[i];
			}
		}
		return bean;
	}

	@Override
	public int count() {
		return count;
	}

	@Override
	public boolean existMember(String id, String pass) {
		boolean exist = false;
		for(int i=0;i<count;i++) {
			if(members[i].getId().equals(id) && members[i].getPass().equals(pass)) {
				exist = true;
			}
		}
		return exist;
	}

	@Override
	public void updatePass(String id, String pass, String newpass) {
		for(int i=0;i<count;i++) {
			if(existMember(id,pass)) {
				members[i].setPass(newpass);
				break;
			}
		}
	}

	@Override
	public void deleteMember(String id, String pass) {
		for(int i=0;i<count;i++) {
			if(existMember(id,pass)) {
				members[i] = members[count-1];
				members[count-1] = null;
				count--;
			}else {
				break;
			}
		}
	}
}
