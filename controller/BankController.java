package controller;

import javax.swing.JOptionPane;
import domain.*;
import service.*;
public class BankController {
	public void start() {
		MemberBean bean = null;
		MemberService memberService = new MemberServiceImpl();
		while(true) {
			switch(JOptionPane.showInputDialog("0.종료\n1.회원가입\n2.회원목록\n3.이름검색\n4.ID검색\n5.회원수\n6.로그인\n7.비번변경\n8.탈퇴")) {
			case "0" :
				JOptionPane.showMessageDialog(null,"종료합니다.");
				return;
			case "1" :
				memberService.createMember(JOptionPane.showInputDialog("ID입력"),
						JOptionPane.showInputDialog("PASS 입력"),
						JOptionPane.showInputDialog("NAME 입력"),
						JOptionPane.showInputDialog("SSN 입력"));
				break;
			case "2" :
				JOptionPane.showMessageDialog(null, memberService.findAll());
				break;
			case "3" :
				JOptionPane.showMessageDialog(null,memberService.findName(JOptionPane.showInputDialog("검색하실 이름")));
				break;
			case "4" :
				JOptionPane.showMessageDialog(null, memberService.findId(JOptionPane.showInputDialog("검색하실 ID")));
				break;
			case "5" :
				JOptionPane.showMessageDialog(null, memberService.count()+"명");
				break;
			case "6" :
				JOptionPane.showMessageDialog(null,memberService.existMember(JOptionPane.showInputDialog("ID 입력"),
						JOptionPane.showInputDialog("PASS 입력")));
				break;
			case "7" :
				memberService.updatePass(JOptionPane.showInputDialog("ID 입력"), 
						JOptionPane.showInputDialog("PASS 입력"), 
						JOptionPane.showInputDialog("변경하실 PASS 입력"));
				break;
			case "8" :
				memberService.deleteMember(JOptionPane.showInputDialog("삭제할 ID 입력"),
						JOptionPane.showInputDialog("삭제할 비밀번호입력"));
				break;
			}
		}
	}
}
