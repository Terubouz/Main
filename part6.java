import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.text.BadLocationException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.math.BigDecimal;
import java.awt.Container;
import java.awt.image.BufferedImage;
class part6 extends JFrame implements ActionListener{
	JLabel label;
	JLabel msg1;
	JTextField text;
	static JPanel p;
	static BufferedImage biAll;
	
	public static void main(String args[])throws java.io.IOException{
		part6 frame = new part6("Crypto�ŋ��\���z�v�Z�c�[��");
		int x = 0;
		int y = 0;
		int cw = 40;
		int ch = 60;
		int sw = 480;
		int sh = 300;
		//�摜���ꕔ���Ő؂����ĕ\������v���O����
		java.io.File file = new java.io.File("Ripple.png");		//�摜�ǂݍ���	
		biAll = ImageIO.read(file);	
		putImage(x,y,cw,ch,sw,sh);
	//	JLabel background = new JLabel(new ImageIcon("Ripple.png"));
	//	frame.add(background);
		frame.setVisible(true);
		
	}
	
/*	setFont(new java.awt.Font(null, 0, 40));
 *	setForeground(new java.awt.Color(70,170,40));
 */		
	
	part6(String title)throws java.io.IOException{
		setTitle(title);
		setBounds(140,100,660,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		text = new JTextField(30);
		JButton button = new JButton("Get");
		button.addActionListener(this);
		
		
		msg1 = new JLabel(" aaaaa");
		msg1.setFont(new java.awt.Font(null, 0, 30));
		msg1.setForeground(new java.awt.Color(70,10,40));
		msg1.setBounds(20,50,50,90);

		
		JPanel  panel1 = new JPanel();
		
		JLabel msg2 = new JLabel("�m�藘�v�����:");
		msg2.setFont(new java.awt.Font(null, 0, 25));
	//	panel1.add(new JLabel("�m�藘�v����� :"));
		panel1.add(msg2);
		
		JPanel  p = new JPanel();
		p.add(panel1);
		p.add(text);
		p.add(button);
		p.add(msg1);


		
		
		
	//	putImage(x,y,cw,ch,sw,sh);
		
/*		{	
				java.awt.image.BufferedImage biAll = javax.imageio.ImageIO.read(file); 	//�S�̂̃C���[�W
				java.awt.image.BufferedImage biSub = biAll.getSubimage(cx * x,cy * y,cx,cy);		//�ꕔ���w�肵���C���[�W
				javax.swing.ImageIcon ii = new javax.swing.ImageIcon(biSub);			//�C���[�W�A�C�R���ɒ���
				javax.swing.ImageIcon ii = new javax.swing.ImageIcon(biAll);			//�C���[�W�A�C�R���ɒ���
				JLabel jImage = new JLabel(ii);					//�C���[�W�֐��Ń��x���ɑ��
				jImage.setBounds(cx,cy,cx,cy);					//
				p.add(jImage);
			}
*/
		
		
		label = new JLabel();

		msg1.setHorizontalAlignment(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);

		Container contentPane = getContentPane();
	//	contentPane.add(msg1,BorderLayout.WEST);
		contentPane.add(p, BorderLayout.NORTH);
		contentPane.add(label,BorderLayout.SOUTH);
	}

	
	public static String con = null;

	static void putImage(int x, int y, int cw, int ch, int sw, int sh){
		
				BufferedImage biSub = biAll.getSubimage(cw * x,ch * y,cw,ch);		//�ꕔ���w�肵���C���[�W
				Image im = biSub.getScaledInstance(sw, sh, Image.SCALE_DEFAULT);
				javax.swing.ImageIcon ii = new javax.swing.ImageIcon(im);			//�C���[�W�A�C�R���ɒ���
				JLabel jImage = new JLabel(ii);					//�C���[�W�֐��Ń��x���ɑ��
				jImage.setSize(sw,sh);					//
		try {
				p.add(jImage);
		}catch(NullPointerException error){
			String str = "�摜��ǂݍ��߂܂���";
			put("�摜��ǂݍ��߂܂���");
			
		}
	}

	public static void put(String str){
		System.out.println(str);
	}

	public void actionPerformed(ActionEvent e){
		
		
		try {String data = text.getText();				//�e�L�X�g�{�b�N�X�ɓ��͂��ꂽ�f�[�^��data�ɑ��
			int total = Integer.parseInt(data);			//data��int�^�ɕϊ�����total�ɑ��
			Jud(total);     							//Jud���\�b�h��total�̒l�ɉ����ĕ\�����e�𔻕ʂ���
		
		}catch(NumberFormatException error){			//try��catch�Ő��l�ȊO�����͂��ꂽ�Ƃ��ɃG���[�\������
			String con = "�l���s���ł�";
			System.out.println(con);
			label.setText(con);
			label.setFont(new java.awt.Font(null, 0, 40));
			label.setForeground(new java.awt.Color(90,70,240));
			label.setBounds(20,30,50,40);
			
		}
			
		label.setText(con);
		label.setFont(new java.awt.Font(null, 0, 40));
		label.setForeground(new java.awt.Color(90,70,240));
		label.setBounds(20,30,50,40);
		
	}
	public static String Jud(int total){
		
		String tax[] = {"0.15","0.2","0.3","0.33","0.43","0.5","0.55"};
		String app;
		con = "�m��\���͕K�v����܂���B";
		if (total >= 200000 && total < 1950000){
			app = tax[0];
			String strNum = String.valueOf(total);
			BigDecimal price = new BigDecimal(strNum);
			BigDecimal tax1 = new BigDecimal(app);
			BigDecimal result = price.multiply(tax1);
			put("<html>���m��\�����K�v�ł��B<br>�@�x�������z�F" + result + "�~");
			con = "<html>���m��\�����K�v�ł��B<br>�@�x�������z�F" + result + "�~";
			return con;
		}
		else if (total >= 1950000 && total < 3300000){
			app = tax[1];
			String strNum = String.valueOf(total);
			BigDecimal price = new BigDecimal(strNum);
			BigDecimal tax1 = new BigDecimal(app);
			BigDecimal result = price.multiply(tax1);
			BigDecimal back = result.setScale(0,BigDecimal.ROUND_UP);
		 	BigDecimal a = BigDecimal.valueOf(97500);
			con = "<html>���m��\�����K�v�ł��B<br>�@�x�������z�F" + result + "�~";
			return con;
		}
		else if (total >= 3300000 && total < 6950000){
			app = tax[2];
			String strNum = String.valueOf(total);
			BigDecimal price = new BigDecimal(strNum);
			BigDecimal tax1 = new BigDecimal(app);
			BigDecimal result = price.multiply(tax1);
			BigDecimal back = result.setScale(0,BigDecimal.ROUND_UP);
		 	BigDecimal a = BigDecimal.valueOf(427500);
			con = "<html>���m��\�����K�v�ł��B<br>�@�x�������z�F" + result + "�~";
			return con;
		}
		else if (total >= 6950000 && total < 9000000){
			app = tax[3];
			String strNum = String.valueOf(total);
			BigDecimal price = new BigDecimal(strNum);
			BigDecimal tax1 = new BigDecimal(app);
			BigDecimal result = price.multiply(tax1);
			BigDecimal back = result.setScale(0,BigDecimal.ROUND_UP);
		 	BigDecimal a = BigDecimal.valueOf(636000);
			con = "<html>���m��\�����K�v�ł��B<br>�@�x�������z�F" + result + "�~";
			return con;
		}
		else if (total >= 9000000 && total < 18000000){
			app = tax[4];
			String strNum = String.valueOf(total);
			BigDecimal price = new BigDecimal(strNum);
			BigDecimal tax1 = new BigDecimal(app);
			BigDecimal result = price.multiply(tax1);
			BigDecimal back = result.setScale(0,BigDecimal.ROUND_UP);
		 	BigDecimal a = BigDecimal.valueOf(1536000);
			con = "<html>���m��\�����K�v�ł��B<br>�@�x�������z�F" + result + "�~";
			return con;
		}
		else if (total >= 18000000 && total < 40000000){
			app = tax[5];
			String strNum = String.valueOf(total);
			BigDecimal price = new BigDecimal(strNum);
			BigDecimal tax1 = new BigDecimal(app);
			BigDecimal result = price.multiply(tax1);
			BigDecimal back = result.setScale(0,BigDecimal.ROUND_UP);
		 	BigDecimal a = BigDecimal.valueOf(2796000);
			con = "<html>���m��\�����K�v�ł��B<br>�@�x�������z�F" + result + "�~";
			return con;
		}
		else if (total >= 40000000 ){
			app = tax[6];
			String strNum = String.valueOf(total);
			BigDecimal price = new BigDecimal(strNum);
			BigDecimal tax1 = new BigDecimal(app);
			BigDecimal result = price.multiply(tax1);
			BigDecimal back = result.setScale(0,BigDecimal.ROUND_UP);
		 	BigDecimal a = BigDecimal.valueOf(4796000);
			con = "<html>���m��\�����K�v�ł��B<br>�@�x�������z�F" + result + "�~";
			return con;
		}
		else{
			con = "���m��\���̕K�v�͂���܂���B";
			return con;
		}
		
		
	
	}
}

	