package ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.concurrent.CopyOnWriteArrayList;

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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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
            new Object[] { "UTF-8", "GBK", "GB2312", "ASCII", "unicode"});

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
    private final JTextArea taInfo = new JTextArea(getHelpMessage());
    private CopyOnWriteArrayList<String> logqueue = new CopyOnWriteArrayList<String>();
    
    private void initFrame() {
        this.taInfo.getDocument().addDocumentListener(new DocumentListener() {
            
            @Override
            public void removeUpdate(DocumentEvent e) {
                
            }
            
            @Override
            public void insertUpdate(DocumentEvent e) {
                ConvertorFrame.this.taInfo.setCaretPosition(ConvertorFrame.this.taInfo.getText().length());
                
            }
            
            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }
        });
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

    public ConvertorFrame() {
        super("Encoding Convertor");
        logger = new Logger() {
            public void log(String message) {
                logqueue.add(message);
            }

            public void space() {
                synchronized (taInfo) {
                    ConvertorFrame.this.taInfo.append("\n");
                    ConvertorFrame.this.taInfo.append(
                            "-----------------------------------------------------------------------------------------");
                    ConvertorFrame.this.taInfo.append("\n");
                }
            }
        };
        converController = ConvertController.getConvertController();
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
        BufferedImage image = ImageIO.read(url);
        mainframe.setIconImage(image);
        new Thread(mainframe.new LogInfo()).start();
    }

    private void checkTgdir() {
        if (!this.tgdir.getText().equals(this.tgdir_temp)) {
            this.tgdir_temp = this.tgdir.getText();
            this.converController.setTempFile(this.tgdir.getText());
        }
    }

    private void checkAdtype() {
        if (!this.adType.getText().equals(this.adtype_temp)) {
            this.adtype_temp = this.adType.getText();
            this.converController.setAdType(this.adType.getText());
        }
    }

    private void checkTgtype() {
        if (!this.tgType.getText().equals(this.tgtype_temp)) {
            this.tgtype_temp = this.tgType.getText();
            this.converController.setTgType(this.tgType.getText());
        }
    }

    private String getHelpMessage() {
        StringBuffer helpMessage = new StringBuffer();
//        try {
//            URL url = ConvertorFrame.class.getResource("/help/help.txt");
//            System.out.println(url);
//            InputStream in = new FileInputStream(new File(url.getPath()));
//            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                helpMessage.append(line + "\n");
//            }
//            reader.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return helpMessage.toString();
        helpMessage.append("编码转换器简介：\n")
        .append(" 对用户选中的文件进行字符编码转换，自动检测选中文件的原编码格式，支持多种格式转换。\n")
        .append("操作步骤：\n")
        .append(" 1. 选择需要转换的文件（若选择文件夹将自动扫描文件夹及子文件夹下的所有文件）\n")
        .append(" 2. 选择需要转换的目标字符编码格式。\n")
        .append(" 3. 输入需要过滤的文件类型（可选）。例：所有的 \".txt\"文本文件不需要转换，则输入\n")
        .append("    文件的后缀 \"txt\",若有多种需要过滤的格式则使用逗号\",\"隔开\n")
        .append(" 4. 输入目标文件格式（可选）。和过滤文件类型的要求一样\n")
        .append(" 5. 选择是否过滤以 \".\"作为文件名开头的隐藏文件\n")
        .append(" 6. 点击\"开始转换\");");
        return helpMessage.toString();
    }

    private FileFilter dirctoryFileFilter = new FileFilter() {
        public boolean accept(File f) {
            return f.isDirectory();
        }

        public String getDescription() {
            return "Directory";
        }
    };
    
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
            jfc.changeToParentDirectory();
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
            this.converController.setHive(this.hivecb.isSelected());
        } else if (ob.equals(this.query)) {
            this.checkAdtype();
            this.checkTgdir();
            this.checkTgtype();
            this.converController.query(true);
        } else if (ob.equals(this.enchangeStart)) {
            this.checkAdtype();
            this.checkTgdir();
            this.checkTgtype();
            this.converController.encodingConvertStart();
        }
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
    
    class LogInfo implements Runnable{

//        String message;
        /* 
         * @see java.lang.Runnable#run()
         */
        @Override
        public void run() {
            while(true){
                for(int i=0;i<logqueue.size();i++){
                    taInfo.append(logqueue.get(i) + "\n");
                    logqueue.remove(i);
                    taInfo.repaint();
                    jsp.repaint();
//                    jsp.getParent().repaint();
                    
                }
            }
        
        }
    }

}
