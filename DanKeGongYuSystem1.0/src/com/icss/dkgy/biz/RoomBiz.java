/**  
* <p>Title: RoomBiz.java</p>  
* <p>Description: </p>   
* <p>Company: icss.205.class</p>  
* @author �ι�ΰ 
* @date 2018��10��30��  
* @version 1.0  
*/
package com.icss.dkgy.biz;

import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.dkgy.dao.RoomDao;
import com.icss.dkgy.entity.RoomEntity;
import com.icss.dkgy.util.ResultPage;

/**  
 * @Title: RoomBiz
 * @Description:
 * @author �ι�ΰ
 * @createTime 2018��10��30������3:17:26
 */
public class RoomBiz {

	
	RoomDao dao = new RoomDao();
	
	
   
	/**  
	 * @Title: searchText
	 * @Description:
	 * @author �ι�ΰ
	 * @param string
	 * @return  
	 * @date 2018��10��30������4:14:42
	 */
	//ͨ���������ѯ��Դ��Ϣ
	public ArrayList<RoomEntity> searchText(String text) {
		ArrayList<RoomEntity> rooms = null;
		try {
			rooms = dao.searchText(text); //����dao��
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dao.closeConnection();
		}
		
		return rooms;
	}



	/**
	 * �鿴���з�Դ��Ϣ
	 */
	public ArrayList<RoomEntity> findAllRoom() {
		ArrayList<RoomEntity> rooms = null;
		try {
			rooms = dao.findAllRoom();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dao.closeConnection();
		}
		return rooms;
	}










	/**
	 *��ҳ��̨��ѯ���з�����Ϣ
	 */
	public void getPageInfo(ResultPage<RoomEntity> page) {
		try {
			 //1.��ȡÿҳչʾ�����ݣ�ÿҳչʾ������   ��ʼ����   1-10    2  11-20
			int pagesize = 3; //ÿҳ��ʾ������
			int startPage = (page.getCurrentPage()-1)*pagesize;   //��ʼ�����Ĺ���  ����ǰҳ-1��*ÿҳ��ʾ����
			//��ѯ��ҳ����,���Ұ�����set��page������
			ArrayList<RoomEntity> rooms = dao.getRoomInfo(startPage,pagesize);
			page.setList(rooms);
			
			//2.�����������Ұ�����set��page������
			int totalCount = dao.selectCount(); 
			page.setTotalCount(totalCount);
			
			//3.������ҳ����������ɣ�������%ÿҳ��ʾ����==0��������/ÿҳ��ʾ����:������/ÿҳ��ʾ����+1
			int totalPage =  totalCount%pagesize==0?totalCount/pagesize:totalCount/pagesize+1;
			page.setTotalPage(totalPage);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dao.closeConnection();
		}
		
	}




	/**  
	 * @Title: findRoomDetail
	 * @Description: ��������
	 * @author �ι�ΰ
	 * @param parseInt
	 * @return  
	 * @date 2018��11��3������6:54:17
	 */
	public ArrayList<RoomEntity> findRoomDetail(int roomid) {
		ArrayList<RoomEntity> rooms = null;
		try {
			rooms = dao.findRoomDetail(roomid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dao.closeConnection();
		}
		return rooms;
		
	}



	/**  
	 * @Title: collectRoom
	 * @Description:  �ղط��ݲ���
	 * @author �ι�ΰ
	 * @param parseInt
	 * @param phone
	 * @return  
	 * @date 2018��11��7������12:00:56
	 */
	public int collectRoom(int roomid, String phone) {
		int flag = 0 ;
		try {
			flag = dao.findCollect(roomid,phone);	//��ѯ�Ƿ��ղ�
			if(flag==1){
				flag=dao.addCollect(roomid,phone);  // flag =1���δ�ղأ�����ղ�
			}else if(flag==2) {
				flag=dao.delectCollect(roomid,phone);// flag=2 ������ղأ�ȡ���ղ�
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dao.closeConnection();
		}

		
		return flag;
	}



	/**  
	 * @Title: findCollectRoom
	 * @Description:��ȡ�û��ղصķ�Դ��Ϣ
	 * @author �ι�ΰ
	 * @param phone
	 * @return  
	 * @date 2018��11��9������11:30:09
	 */
	public ArrayList<RoomEntity> findCollectRoom(String phone) {
		ArrayList<RoomEntity> rooms = null;
		try {
			rooms = dao.findCollectRoom(phone);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dao.closeConnection();
		}
		return rooms;
	}



	/**
	 * ����Ա��ӷ�Դ
	 */
	public int addRoom(RoomEntity room) {
		int c = 0;
		try {
			c = dao.addRoom(room);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dao.closeConnection();
		}
		
		return c;
	}



	/**
	 * ����Աɾ����Դ��Ϣ
	 */
	public int delRooms(String[] roomnums) {
		int flag = 0;
		try {
			//�ֶ���������
			dao.beginTransaction();
			flag = dao.delRooms(roomnums);
			//�ɹ�һ���ύ
			dao.commit();
		} catch (Exception e) {
			try {
				dao.rollback();  //ʧ��һ��ع�
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			dao.closeConnection();
		}
		return flag;
	}



	/**
	 * ����Ա��ѯ���ַ�Դ��Ϣ
	 */
	public void getPageInfo(ResultPage<RoomEntity> page, String address, int typeid, String status) {
		try {
			 //1.��ȡÿҳչʾ�����ݣ�ÿҳչʾ������   ��ʼ����   1-3    2  4-6
			int pagesize = 3; //ÿҳ��ʾ������
			int startPage = (page.getCurrentPage()-1)*pagesize;   //��ʼ�����Ĺ���  ����ǰҳ-1��*ÿҳ��ʾ����
			//��ѯ��ҳ����,���Ұ�����set��page������
			ArrayList<RoomEntity> rooms = dao.getRoomInfoBack(startPage,pagesize,address,typeid,status);
			page.setList(rooms);
			
			//2.�����������Ұ�����set��page������
			int totalCount = dao.selectRoomCount(address,typeid,status); 
			page.setTotalCount(totalCount);
			
			//3.������ҳ����������ɣ�������%ÿҳ��ʾ����==0��������/ÿҳ��ʾ����:������/ÿҳ��ʾ����+1
			int totalPage =  totalCount%pagesize==0?totalCount/pagesize:totalCount/pagesize+1;
			page.setTotalPage(totalPage);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dao.closeConnection();
		}
		
		
	}



	/**
	 * ɾ��������Դ��Ϣ
	 */
	public void delRooms(String roomnum) {
		try {
			dao.delRoom(roomnum);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dao.closeConnection();
		}
		
	}


}
