package ui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;

import controller.ConvertController;

public class ConvertorFrame extends JFrame implements ActionListener, FocusListener {
    private static final long serialVersionUID = -5099311063371916825L;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    public String tgdir_temp = "";
    private String tgtype_temp = "";
    private String adtype_temp = "";
    private ConvertController converController;
    private Logger logger;
    private JScrollPane jsp;

    private JComboBox tgcharsetlist = new JComboBox(
            new Object[] { "UTF-8", "GBK", "ASCII", "unicode"});

    private JMenu menu1 = new JMenu("Operate");
    private JMenuItem about = new JMenuItem("about");
    private JMenuItem exitMenu = new JMenuItem("Exit");
    private JCheckBox hivecb = new JCheckBox();
    private JButton chooseflo = new JButton("...");
    public JTextField tgdir = new JTextField();
    private JTextField adType = new JTextField();
    private JTextField tgType = new JTextField();
    private JButton query = new JButton("查询");
    private JButton enchangeStart = new JButton("开始转换");
    //单独
    private final JTextArea taInfo = new JTextArea(getHelpMessage());

    private void initFrame() {
        initMenu();
        initTopPanel();
        initCenterPanel();
    }

    private void initMenu() {
        JMenuBar menubar = new JMenuBar();
        menu1.add(about);
        menu1.addSeparator();
        menu1.add(exitMenu);
        about.addActionListener(this);
        exitMenu.addActionListener(this);
        menubar.add(menu1);
        setJMenuBar(menubar);
    }

    private void initTopPanel() {
        JPanel toppanel = new JPanel();
        toppanel.setLayout(null);
        JLabel tgdirlb = new JLabel("文件夹:", SwingConstants.RIGHT);
        JLabel adTypelb = new JLabel("过滤文件:", SwingConstants.RIGHT);
        JLabel tgTypelb = new JLabel("目标文件:", SwingConstants.RIGHT);
        JLabel tgcharsetlb = new JLabel("目标字符编码:", SwingConstants.RIGHT);
        JLabel hivefile = new JLabel("隐藏文件:", SwingConstants.RIGHT);

        tgdirlb.setBounds(10, 15, 60, 30); // 文件夹：
        tgdir.setBounds(70, 15, 300, 30); // 输入框
        chooseflo.setBounds(370, 15, 80, 30); // 选择框
        tgcharsetlb.setBounds(490, 15, 80, 30); // 目标字符编码
        tgcharsetlist.setBounds(580, 15, 150, 30); // 列表框

        adTypelb.setBounds(10, 55, 60, 30); // 过滤文件：
        adType.setBounds(70, 55, 100, 30); // 输入框
        tgTypelb.setBounds(180, 55, 60, 30); // 目标文件
        tgType.setBounds(250, 55, 100, 30);
        hivefile.setBounds(365, 55, 60, 30); //
        this.hivecb.setBounds(425, 55, 30, 30); //
        this.query.setBounds(490, 55, 80, 30);
        enchangeStart.setBounds(580, 55, 150, 30);// 开始转换

        this.exitMenu.addActionListener(this);
        this.about.addActionListener(this);
        // this.tgdir.addActionListener(this);
        // this.adType.addActionListener(this);
        // this.tgType.addActionListener(this);
        // this.tgdir.getDocument().addDocumentListener(this);
        // this.adType.getDocument().addDocumentListener(this);
        // this.tgType.getDocument().addDocumentListener(this);
        this.tgdir.addFocusListener(this);
        this.adType.addFocusListener(this);
        this.tgType.addFocusListener(this);
        this.chooseflo.addActionListener(this);
        this.enchangeStart.addActionListener(this);
        this.tgcharsetlist.addActionListener(this);
        this.query.addActionListener(this);
        this.hivecb.addActionListener(this);

        toppanel.add(tgdirlb);
        toppanel.add(tgdir);
        toppanel.add(chooseflo);
        toppanel.add(adTypelb);
        toppanel.add(adType);
        toppanel.add(tgTypelb);
        toppanel.add(tgType);
        toppanel.add(hivefile);
        toppanel.add(this.hivecb);
        toppanel.add(tgcharsetlb);
        toppanel.add(tgcharsetlist);
        toppanel.add(this.query);
        toppanel.add(enchangeStart);

        // JPanel tmpPanel = new JPanel();
        // tmpPanel.add(toppanel, "Center");

        toppanel.setPreferredSize(new Dimension(600, 90));
        add(toppanel, "North");
    }

    private void initCenterPanel() {
        jsp = new JScrollPane(this.taInfo);
        jsp.setBounds(100, 90, 450, 300);
        add(jsp, "Center");
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object ob = event.getSource();
        if (ob == this.about) {
            System.out.println("about");
            // JFrame jf = new JFrame("about");
            // jf.setSize(200, 100);
            // jf.setVisible(true);
        } else if (ob.equals(this.exitMenu)) {
            System.exit(0);
        } else if (ob.equals(this.chooseflo)) {
            JFileChooser jfc = new JFileChooser();
            jfc.setDialogTitle("请选择需要转换的文件夹\\文件");
            jfc.setFileFilter(this.dirctoryFileFilter);
            jfc.setMultiSelectionEnabled(true);
            jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            jfc.setApproveButtonText("确定");
            jfc.showOpenDialog(this);
            // TODO 记住用户选择的文件
            File[] files = jfc.getSelectedFiles();
            this.converController.setTempFile(files);
            if (files.length != 0) {// 等于一个的时候可能是一个文件夹也可能是一个文件
                String tgdirpath;
                if (files.length == 1)
                    tgdirpath = files[0].isDirectory() ? files[0].getPath()
                            : files[0].getParent();
                else
                    tgdirpath = files[0].getParent();
                this.tgdir.setText(tgdirpath);
                this.tgdir_temp = this.tgdir.getText();

            }

        } else if (ob.equals(this.tgcharsetlist)) {
            this.converController
                    .setTgEncoding((String) this.tgcharsetlist.getSelectedItem());
        } else if (ob.equals(this.hivecb)) {
            // System.out.println("hivecb");
            this.converController.setHive(this.hivecb.isSelected());
        } else if (ob.equals(this.query)) {
            // System.out.println("query");
            this.checkAdtype();
            this.checkTgdir();
            this.checkTgtype();
            this.converController.query(true);
            // int height=10;
            // Point p = new Point();
            // System.out.println("count : " + this.taInfo.getLineCount());
            // p.setLocation(0,this.taInfo.getLineCount()*height);
            // this.jsp.setLocation(p);
        } else if (ob.equals(this.enchangeStart)) {
            this.checkAdtype();
            this.checkTgdir();
            this.checkTgtype();
            this.converController.encodingConvertStart();
        }
    }

    public ConvertorFrame() {
        super("Encoding Convertor");
        logger = new Logger() {
            public void log(String message) {
                ConvertorFrame.this.taInfo.append(message + "\n");
            }

            public void space() {
                ConvertorFrame.this.taInfo.append("\n");
                ConvertorFrame.this.taInfo.append(
                        "-----------------------------------------------------------------------------------------");
                ConvertorFrame.this.taInfo.append("\n");
            }
        };
        converController = ConvertController.getInstence();
        converController.setLogger(logger);
        initFrame();
        setDefaultCloseOperation(3);
        setSize(WIDTH, HEIGHT);
        setVisible(true);

    }

    public static void main(String[] args) throws Exception {
        try {
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
            UIManager.put("RootPane.setupButtonVisible", false);

        } catch (Exception e) {

        }

        ConvertorFrame mainframe = new ConvertorFrame();
        URL url = ConvertorFrame.class.getResource("/img/motug.png");
        Image image = ImageIO.read(url);
        mainframe.setIconImage(image);
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object r = e.getSource();
        if (r.equals(this.tgdir)) {
            this.checkTgdir();
        } else if (r.equals(this.adType)) {
            this.checkAdtype();
        } else if (r.equals(this.tgType)) {
            this.checkTgtype();
        }
    }

    public void checkTgdir() {
        if (!this.tgdir.getText().equals(this.tgdir_temp)) {
            this.tgdir_temp = this.tgdir.getText();
            this.converController.setTempFile(this.tgdir.getText());
        }
    }

    public void checkAdtype() {
        if (!this.adType.getText().equals(this.adtype_temp)) {
            this.adtype_temp = this.adType.getText();
            this.converController.setAdType(this.adType.getText());
        }
    }

    public void checkTgtype() {
        if (!this.tgType.getText().equals(this.tgtype_temp)) {
            this.tgtype_temp = this.tgType.getText();
            this.converController.setTgType(this.tgType.getText());
        }
    }

    private String getHelpMessage() {
        StringBuffer helpMessage = new StringBuffer();
        try {
            String path = ConvertorFrame.class.getResource("/help.txt").getPath();
            InputStream in = new FileInputStream(new File(path));
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = reader.readLine()) != null) {
                helpMessage.append(line + "\n");
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return helpMessage.toString();
    }

    private FileFilter dirctoryFileFilter = new FileFilter() {
        public boolean accept(File f) {
            return f.isDirectory();
        }

        public String getDescription() {
            return "Dirctory";
        }
    };

}
