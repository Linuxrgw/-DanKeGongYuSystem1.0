/**  
* <p>Title: RoomDao.java</p>  
* <p>Description: </p>   
* <p>Company: icss.205.class</p>  
* @author �ι�ΰ 
* @date 2018��10��29��  
* @version 1.0  
*/
package com.icss.dkgy.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.text.SimpleDateFormat;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import com.icss.dkgy.entity.RoomEntity;


// badac acd
/**  
 * @Title: RoomDao
 * @Description:
 * @author �ι�ΰ
 * @createTime 2018��10��29������4:07:16
 */
public class RoomDao extends BaseDao{

	/**  
	 * @Title: searchText
	 * @Description:
	 * @author �ι�ΰ 
	 * @param text
	 * @return  
	 * @date 2018��10��30������4:52:43
	 */
	public ArrayList<RoomEntity> searchText(String text)throws Exception {
				//1������
				openConnection();
				//2����Ԥ�������
				String sql = "select *from room where comment like ?";
				
				PreparedStatement pst =  this.conn.prepareStatement(sql);
				pst.setString(1,"%"+text+"%");
				
				//3ִ�в��������õ������conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				//4��������
				ArrayList<RoomEntity> rooms = new ArrayList<RoomEntity>();//�������϶��������洢ͼ����Ϣ
				RoomEntity room = null;
				while (rs.next()) {
					room =new RoomEntity();
					room.setRoomnum(rs.getInt("roomnum"));
					room.setAddress(rs.getString("address"));
					room.setPrice(rs.getDouble("price"));
					room.setArea(rs.getDouble("area"));
					room.setTypeid(rs.getInt("typeid"));
					room.setPaymethod(rs.getString("paymethod"));
					room.setStatus(rs.getString("status"));
					room.setSubway(rs.getString("subway"));
					room.setImgpath(rs.getString("imgpath"));
					room.setOwnerid(rs.getInt("ownerid"));
					//room.setRentdate(rs.getTimestamp("rentdate"));
					room.setComment(rs.getString("comment"));
					rooms.add(room);
					 
					
					}
				return rooms;
	}

	/**  
	 * @Title: findRoomDetail
	 * @Description: �鿴��Դ����
	 * @author �ι�ΰ
	 * @param roomid
	 * @return  
	 * @date 2018��11��3������9:13:02
	 */
	public ArrayList<RoomEntity> findRoomDetail(int roomid)throws Exception{
		//1������
		openConnection();
		//2����Ԥ�������
		String sql = "select *from room where roomnum =?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, roomid);
		//3ִ�в��������õ������
		ResultSet rs = pst.executeQuery();
		//4��������
		ArrayList<RoomEntity>rooms = new ArrayList<RoomEntity>();//�������϶��������洢ͼ����Ϣ
		RoomEntity room = null;
		while (rs.next()) {
			room = new RoomEntity();
			room.setRoomnum(rs.getInt("roomnum"));
			room.setAddress(rs.getString("address"));
			room.setPrice(rs.getDouble("price"));
			room.setArea(rs.getDouble("area"));
			room.setTypeid(rs.getInt("typeid"));
			room.setPaymethod(rs.getString("paymethod"));
			room.setStatus(rs.getString("status"));
			room.setSubway(rs.getString("subway"));
			room.setImgpath(rs.getString("imgpath"));

			room.setOwnerid(rs.getInt("ownerid"));
			room.setRentdate(rs.getTimestamp("rentdate"));

			
			//room.setRentdate(rs.getTimestamp("rentdate"));

			room.setOwnerid(rs.getInt("ownerid"));
			//room.setRentdate(rs.getTimestamp("rentdate"));

			room.setComment(rs.getString("comment"));
			rooms.add(room);
		}
		
		return rooms;
	}

	/**  
	 * @Title: collectroom
	 * @Description:
	 * @author �ι�ΰ
	 * @param roomid
	 * @return  
	 * @date 2018��11��3������3:27:43
	 */
	public boolean collectRoom(int roomid)throws Exception {
		// 1��������
		openConnection();
		// 2������Ԥ�������
		String sql = "update t_carshop set count = count + 1";
		PreparedStatement pst = conn.prepareStatement(sql);
		
		// 3��ִ�в���
		int flag = pst.executeUpdate();
		
		return false;
	}
	
	/**
	 * �鿴���з�Դ��Ϣ
	 * @throws Exception 
	 */
	public ArrayList<RoomEntity> findAllRoom() throws Exception {
		//1��������
		openConnection();
		//2������Ԥ�������
		String sql = "select * from room";
		PreparedStatement pst = conn.prepareStatement(sql);
		// 3.ִ�в��������õ������
		ResultSet rs = pst.executeQuery();
		// 4.��������
		ArrayList<RoomEntity> rooms = new ArrayList<RoomEntity>();
		RoomEntity room = null;
		while (rs.next()) {
			room = new RoomEntity();
			room.setRoomnum(rs.getInt("roomnum"));
			room.setAddress(rs.getString("address"));
			room.setArea(rs.getDouble("area"));
			room.setComment(rs.getString("comment"));
			room.setImgpath(rs.getString("imgpath"));
			room.setOwnerid(rs.getInt("ownerid"));
			room.setPaymethod(rs.getString("paymethod"));
			room.setPrice(rs.getDouble("price"));
			room.setRentdate(rs.getTimestamp("rentdate"));
			room.setStatus(rs.getString("status"));
			room.setSubway(rs.getString("subway"));
			room.setTypeid(rs.getInt("typeid"));	
			rooms.add(room);
		}
		
		return rooms;
	}


	/**
	 * ��ҳ��ѯ���з�����Ϣ
	 * @throws Exception 
	 */
	public ArrayList<RoomEntity> getRoomInfo(int startPage, int pagesize) throws Exception {
		// 1��������
				openConnection();
				// 2������Ԥ�������
				String sql = "select * from room limit ?,? ";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setInt(1, startPage);
				pst.setInt(2, pagesize);
				// 3��ִ�в���,���õ������
				ResultSet rs = pst.executeQuery();
				// 4����������
				ArrayList<RoomEntity> rooms = new ArrayList<RoomEntity>(); // �������϶��������洢ͼ����Ϣ
				RoomEntity room = null;
				while (rs.next()) {
					room = new RoomEntity();
					room.setAddress(rs.getString("address"));
					room.setArea(rs.getDouble("area"));
					room.setComment(rs.getString("comment"));
					room.setOwnerid(rs.getInt("ownerid"));
					room.setPaymethod(rs.getString("paymethod"));
					room.setPrice(rs.getDouble("price"));
					room.setStatus(rs.getString("status"));
					room.setRoomnum(rs.getInt("roomnum"));
					room.setTypeid(rs.getInt("typeid"));
					room.setRentdate(rs.getTimestamp("rentdate"));
					room.setSubway(rs.getString("subway"));	
					room.setImgpath(rs.getString("imgpath"));
					rooms.add(room);
				}
				return rooms;
	}

	/**
	 * ��ѯ���ݵ�����
	 * @throws Exception 
	 */
	public int selectCount() throws Exception {
		// 2������Ԥ�������
		String sql = "select count(*) from room ";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		int totalCount=0;
		while(rs.next()){
			totalCount = rs.getInt(1);
		}
		return totalCount;
	}

	/**  
	 * @Title: findRoomDetail
	 * @Description: �鿴ͼ������
	 * @author �ι�ΰ
	 * @return  
	 * @date 2018��11��3������7:47:42
	 */
	public ArrayList<RoomEntity> findRoomDetail() throws Exception{
				//1��������
				openConnection();
				//2������Ԥ�������
				String sql = "select * from room";
				PreparedStatement pst = conn.prepareStatement(sql);
				// 3.ִ�в��������õ������
				ResultSet rs = pst.executeQuery();
				// 4.��������
				ArrayList<RoomEntity> rooms = new ArrayList<RoomEntity>();
				RoomEntity room = null;
				while (rs.next()) {
					room = new RoomEntity();
					room.setAddress(rs.getString("address"));
					room.setArea(rs.getDouble("area"));
					room.setComment(rs.getString("comment"));
					room.setImgpath(rs.getString("imgpath"));
					room.setOwnerid(rs.getInt("ownerid"));
					room.setPaymethod(rs.getString("paymethod"));
					room.setPrice(rs.getDouble("price"));
					room.setRentdate(rs.getTimestamp("rentdate"));
					room.setStatus(rs.getString("status"));
					room.setSubway(rs.getString("subway"));
					room.setTypeid(rs.getInt("typeid"));	
					rooms.add(room);
				}
				
				return rooms;
	}

	/**
	 * ����Ա��ӷ�Դ
	 * @throws Exception 
	 */
	public int addRoom(RoomEntity room) throws Exception {
		//1��������
		openConnection();
		//2������Ԥ�������
		String sql = "insert into room(address,comment,area,typeid,subway,rentdate,status,price,imgpath,ownerid) values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, room.getAddress());
		pst.setString(2, room.getComment());
		pst.setDouble(3, room.getArea());
		pst.setInt(4, room.getTypeid());
		pst.setString(5, room.getSubway());
		pst.setTimestamp(6, room.getRentdate());
		pst.setString(7, room.getStatus());
		pst.setDouble(8, room.getPrice());
		pst.setString(9, room.getImgpath());
		pst.setInt(10, room.getOwnerid());
		//3��ִ�в���
		int c = pst.executeUpdate();
		return c;
	}


	/**  
	 * @Title: findCollect
	 * @Description: ��ѯ�Ƿ����ղصķ�����Ϣ
	 * @author �ι�ΰ
	 * @param roomid
	 * @param phone
	 * @return  
	 * @date 2018��11��7������1:58:01
	 */
	public int findCollect(int roomid, String phone) throws Exception{
				// 1��������
				openConnection();
				// 2������Ԥ�������
				//������ѯ�����Ӳ�ѯ���÷�
				String sql = "select collectionnum from room r left join collection c on r.roomnum=c.roomnum and   c.phone=? WHERE r.roomnum =?";
//				String sql = "SELECT collectionnum FROM collection WHERE roomnum=? AND phone =?";
				PreparedStatement pst = conn.prepareStatement(sql);
				
				pst.setString(1,phone);
				pst.setInt(2, roomid);
				
				// 3��ִ�в���
				ResultSet rs = pst.executeQuery();
				String res="";
				while(rs.next()){
					res = rs.getString(1);
				}
		 		
				return res==null||"".equals(res)?1:2;  // 1 δ�ղ�   ���в������ݲ���
													   // 2 ���ղ�  ����ɾ�����ݲ���
				
	}

	/**  
	 * @Title: addCollect
	 * @Description:
	 * @author �ι�ΰ
	 * @param roomid
	 * @param phone
	 * @return  
	 * @date 2018��11��7������3:04:42
	 */
	public int addCollect(int roomid, String phone) throws Exception{
		// 1��������
		openConnection();
		// 2������Ԥ�������
		String number = getOrderNum(); // ���ɶ������
		String sql = "INSERT INTO `collection` (`collectionnum`,`roomnum`,`phone`) VALUES (?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, number);
		pst.setInt(2, roomid);
		pst.setString(3, phone);
		
		// 3��ִ�в���
		int flag = pst.executeUpdate();
		
		return flag;
	}
	// �����ղ�ʱ����
				public String getOrderNum() {
					SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
					Date date = new Date();
					String time = df.format(date); // �ѵ�ǰʱ���ʽ�����ַ���
					Random random = new Random();
					int num = (int) (random.nextDouble() * (99999 - 10000 + 1) + 10000); // ����5λ�������
					return time + num;
				}

	/**  
	 * @Title: delectCollect
	 * @Description:  ȡ���ղ�
	 * @author �ι�ΰ
	 * @param roomid
	 * @param phone
	 * @return  
	 * @date 2018��11��7������3:53:39
	 */
	public int delectCollect(int roomid, String phone) throws Exception{
				int flag;
				// 1��������
				openConnection();
				// 2������Ԥ�������
				String sql = "delete from collection where roomnum=? and phone =?";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setInt(1, roomid);
				pst.setString(2, phone);
				
				// 3��ִ�в���
				 pst.executeUpdate();
				
				return flag=2;
	}

	/**  
	 * @Title: findCollectRoom
	 * @Description:
	 * @author �ι�ΰ
	 * @param phone
	 * @return  
	 * @date 2018��11��9������11:43:04
	 */
	public ArrayList<RoomEntity> findCollectRoom(String phone) throws Exception{
		//1��������
		openConnection();
		//2������Ԥ�������
		String sql = "SELECT *FROM room r LEFT JOIN collection c ON r.roomnum =c.roomnum WHERE phone =?";
		PreparedStatement pst = conn.prepareStatement(sql);
		// 3.ִ�в��������õ������
		pst.setString(1, phone);
		ResultSet rs = pst.executeQuery();
		// 4.��������
		ArrayList<RoomEntity> rooms = new ArrayList<RoomEntity>();
		RoomEntity room = null;
		while (rs.next()) {
			room = new RoomEntity();
			room.setAddress(rs.getString("address"));
			room.setArea(rs.getDouble("area"));
			room.setComment(rs.getString("comment"));
			room.setImgpath(rs.getString("imgpath"));
			room.setOwnerid(rs.getInt("ownerid"));
			room.setPaymethod(rs.getString("paymethod"));
			room.setPrice(rs.getDouble("price"));
			room.setRentdate(rs.getTimestamp("rentdate"));
			room.setStatus(rs.getString("status"));
			room.setSubway(rs.getString("subway"));
			room.setTypeid(rs.getInt("typeid"));	
			rooms.add(room);
		}
		
		return rooms;
 


	}

	/**
	 * ����Ա��ѯ���ַ�Դ��Ϣ
	 * @throws Exception 
	 */
//	public ArrayList<RoomEntity> getRoomInfoBack(int startPage, int pagesize,String address, int typeid, String status) throws Exception {
		

//}
//	}

	/**
	 * ��ѯ���������ķ�������
	 * @param status 
	 * @param typeid 
	 * @param address 
	 * @throws Exception 
	 */
	public int selectRoomCount(String address, int typeid, String status) throws Exception {
		// 2������Ԥ�������
		String sql = "select * from room where 1=1 ";
        if("".equals(address)){
        	sql+="and address = "+address;
		}	
        if("".equals(status)){
        	sql+="and status = "+status;
        }
		if(typeid != 9){
			sql+="and typeid = "+typeid;
		}
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		int totalCount=0;
		while(rs.next()){
			totalCount = rs.getInt(1);
		}
		return totalCount;
	}

	/**
	 * ɾ��������Դ��Ϣ
	 * @throws Exception 
	 */
	public void delRoom(String roomnum) throws Exception {
		//1��������
		openConnection();
		//2������Ԥ�������
		String sql = "delete from room where roomnum = ?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, Integer.parseInt(roomnum));
		pst.executeUpdate();
	}

	/**  
	 * @Title: delRooms
	 * @Description:
	 * @author �ι�ΰ
	 * @param roomnums
	 * @return  
	 * @throws Exception 
	 * @date 2018��11��17������10:40:41
	 */
	public int delRooms(String[] roomnums) throws Exception {
		// 1��������
				openConnection();
				//2������Ԥ�������
				String wherein = "(";
				for (int i = 0; i < roomnums.length; i++) {
					wherein += Integer.parseInt(roomnums[i]);
					if (i != roomnums.length - 1) {
						wherein += ",";
					}
				}
				wherein += ")";
				String sql = "delete from room WHERE roomnum in "
						+ wherein;
				PreparedStatement pst = conn.prepareStatement(sql);
				int flag = pst.executeUpdate();
				return flag;
	}

	/**  
	 * @Title: getRoomInfoBack
	 * @Description:
	 * @author �ι�ΰ
	 * @param startPage
	 * @param pagesize
	 * @param address
	 * @param typeid
	 * @param status
	 * @return  
	 * @date 2018��11��17������10:42:47
	 */
	public ArrayList<RoomEntity> getRoomInfoBack(int startPage, int pagesize, String address, int typeid,
			String status) throws Exception{
		// 1��������
				openConnection();
				// 2������Ԥ�������
				String sql = "select * from room where 1=1 ";
		        if("".equals(address)){
		        	sql+="and address = "+address;
				}	
		        if("".equals(status)){
		        	sql+="and status = "+status;
		        }
				if(typeid != 0){
					sql+="and typeid = "+typeid;
				}
				sql+="limit ?,?";
				PreparedStatement pst = conn.prepareStatement(sql);
//				pst.setInt(1, typeid);
//				pst.setString(2, status);
//				pst.setString(3, address);
				pst.setInt(1, startPage);
				pst.setInt(2, pagesize);
				// 3��ִ�в���,���õ������
				ResultSet rs = pst.executeQuery();
				// 4����������
				ArrayList<RoomEntity> rooms = new ArrayList<RoomEntity>(); // �������϶��������洢ͼ����Ϣ
				RoomEntity room = null;
				while (rs.next()) {
					room = new RoomEntity();
					room.setAddress(rs.getString("address"));
					room.setArea(rs.getDouble("area"));
					room.setComment(rs.getString("comment"));
					room.setOwnerid(rs.getInt("ownerid"));
					room.setPaymethod(rs.getString("paymethod"));
					room.setPrice(rs.getDouble("price"));
					room.setStatus(rs.getString("status"));
					room.setRoomnum(rs.getInt("roomnum"));
					room.setTypeid(rs.getInt("typeid"));
					room.setRentdate(rs.getTimestamp("rentdate"));
					room.setSubway(rs.getString("subway"));	
					room.setImgpath(rs.getString("imgpath"));
					rooms.add(room);
				}
				return rooms;
	}



}

















