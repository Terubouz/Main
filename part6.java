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
		part6 frame = new part6("Crypto税金申告額計算ツール");
		int x = 0;
		int y = 0;
		int cw = 40;
		int ch = 60;
		int sw = 480;
		int sh = 300;
		//画像を一部分で切り取って表示するプログラム
		java.io.File file = new java.io.File("Ripple.png");		//画像読み込み	
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
		
		JLabel msg2 = new JLabel("確定利益を入力:");
		msg2.setFont(new java.awt.Font(null, 0, 25));
	//	panel1.add(new JLabel("確定利益を入力 :"));
		panel1.add(msg2);
		
		JPanel  p = new JPanel();
		p.add(panel1);
		p.add(text);
		p.add(button);
		p.add(msg1);


		
		
		
	//	putImage(x,y,cw,ch,sw,sh);
		
/*		{	
				java.awt.image.BufferedImage biAll = javax.imageio.ImageIO.read(file); 	//全体のイメージ
				java.awt.image.BufferedImage biSub = biAll.getSubimage(cx * x,cy * y,cx,cy);		//一部を指定したイメージ
				javax.swing.ImageIcon ii = new javax.swing.ImageIcon(biSub);			//イメージアイコンに直す
				javax.swing.ImageIcon ii = new javax.swing.ImageIcon(biAll);			//イメージアイコンに直す
				JLabel jImage = new JLabel(ii);					//イメージ関数でラベルに代入
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
		
				BufferedImage biSub = biAll.getSubimage(cw * x,ch * y,cw,ch);		//一部を指定したイメージ
				Image im = biSub.getScaledInstance(sw, sh, Image.SCALE_DEFAULT);
				javax.swing.ImageIcon ii = new javax.swing.ImageIcon(im);			//イメージアイコンに直す
				JLabel jImage = new JLabel(ii);					//イメージ関数でラベルに代入
				jImage.setSize(sw,sh);					//
		try {
				p.add(jImage);
		}catch(NullPointerException error){
			String str = "画像を読み込めません";
			put("画像を読み込めません");
			
		}
	}

	public static void put(String str){
		System.out.println(str);
	}

	public void actionPerformed(ActionEvent e){
		
		
		try {String data = text.getText();				//テキストボックスに入力されたデータをdataに代入
			int total = Integer.parseInt(data);			//dataをint型に変換してtotalに代入
			Jud(total);     							//Judメソッドでtotalの値に応じて表示内容を判別する
		
		}catch(NumberFormatException error){			//tryのcatchで数値以外が入力されたときにエラー表示する
			String con = "値が不正です";
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
		con = "確定申告は必要ありません。";
		if (total >= 200000 && total < 1950000){
			app = tax[0];
			String strNum = String.valueOf(total);
			BigDecimal price = new BigDecimal(strNum);
			BigDecimal tax1 = new BigDecimal(app);
			BigDecimal result = price.multiply(tax1);
			put("<html>※確定申告が必要です。<br>　支払い金額：" + result + "円");
			con = "<html>※確定申告が必要です。<br>　支払い金額：" + result + "円";
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
			con = "<html>※確定申告が必要です。<br>　支払い金額：" + result + "円";
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
			con = "<html>※確定申告が必要です。<br>　支払い金額：" + result + "円";
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
			con = "<html>※確定申告が必要です。<br>　支払い金額：" + result + "円";
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
			con = "<html>※確定申告が必要です。<br>　支払い金額：" + result + "円";
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
			con = "<html>※確定申告が必要です。<br>　支払い金額：" + result + "円";
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
			con = "<html>※確定申告が必要です。<br>　支払い金額：" + result + "円";
			return con;
		}
		else{
			con = "※確定申告の必要はありません。";
			return con;
		}
		
		
	
	}
}

	