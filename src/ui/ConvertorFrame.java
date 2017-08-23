package ui;

import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;

import config.BoxConfig;
import config.ButtonConfig;
import config.ComponentConfig;
import config.FrameConfig;
import config.LabelConfig;
import config.PanelConfig;
import config.TextFieldConfig;
import controller.ConvertController;

public class ConvertorFrame extends JFrame{
    private static final long serialVersionUID = -5099311063371916825L;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
//    public String tgdir_temp = "";
//    private String tgtype_temp = "";
//    private String adtype_temp = "";
    private ConvertController converController;
    private Logger logger;
    private JScrollPane jsp;

    private JComboBox tgcharsetlist = new JComboBox(
            new Object[] { "UTF-8", "GBK", "ASCII", "unicode"});

    private JMenu menu1 = new JMenu("Operate");
    private JMenuItem about = new JMenuItem("about");
    private JMenuItem exitMenu = new JMenuItem("Exit");
//    private JCheckBox hivecb = new JCheckBox();
//    private JButton chooseflo = new JButton("...");
//    public JTextField tgdir = new JTextField();
//    private JTextField adType = new JTextField();
//    private JTextField tgType = new JTextField();
//    private JButton query = new JButton("查询");
//    private JButton enchangeStart = new JButton("开始转换");
    //单独
    private final JTextArea taInfo = new JTextArea(getHelpMessage());

    private void initFrame() {
        initMenu();
//        initTopPanel();
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

//    private void initTopPanel() {
//        JPanel toppanel = new JPanel();
//        toppanel.setLayout(null);
//        JLabel tgdirlb = new JLabel("文件夹:", SwingConstants.RIGHT);
//        JLabel adTypelb = new JLabel("过滤文件:", SwingConstants.RIGHT);
//        JLabel tgTypelb = new JLabel("目标文件:", SwingConstants.RIGHT);
//        JLabel tgcharsetlb = new JLabel("目标字符编码:", SwingConstants.RIGHT);
//        JLabel hivefile = new JLabel("隐藏文件:", SwingConstants.RIGHT);
//
//        tgdirlb.setBounds(10, 15, 60, 30); // 文件夹：
//        tgdir.setBounds(70, 15, 300, 30); // 输入框
//        chooseflo.setBounds(370, 15, 80, 30); // 选择框
//        tgcharsetlb.setBounds(490, 15, 80, 30); // 目标字符编码
//        tgcharsetlist.setBounds(580, 15, 150, 30); // 列表框
//
//        adTypelb.setBounds(10, 55, 60, 30); // 过滤文件：
//        adType.setBounds(70, 55, 100, 30); // 输入框
//        tgTypelb.setBounds(180, 55, 60, 30); // 目标文件
//        tgType.setBounds(250, 55, 100, 30);
//        hivefile.setBounds(365, 55, 60, 30); //
//        this.hivecb.setBounds(425, 55, 30, 30); //
//        this.query.setBounds(490, 55, 80, 30);
//        enchangeStart.setBounds(580, 55, 150, 30);// 开始转换
//
//        this.exitMenu.addActionListener(this);
//        this.about.addActionListener(this);
//        // this.tgdir.addActionListener(this);
//        // this.adType.addActionListener(this);
//        // this.tgType.addActionListener(this);
//        // this.tgdir.getDocument().addDocumentListener(this);
//        // this.adType.getDocument().addDocumentListener(this);
//        // this.tgType.getDocument().addDocumentListener(this);
//        this.tgdir.addFocusListener(this);
//        this.adType.addFocusListener(this);
//        this.tgType.addFocusListener(this);
//        this.chooseflo.addActionListener(this);
//        this.enchangeStart.addActionListener(this);
//        this.tgcharsetlist.addActionListener(this);
//        this.query.addActionListener(this);
//        this.hivecb.addActionListener(this);
//
//        toppanel.add(tgdirlb);
//        toppanel.add(tgdir);
//        toppanel.add(chooseflo);
//        toppanel.add(adTypelb);
//        toppanel.add(adType);
//        toppanel.add(tgTypelb);
//        toppanel.add(tgType);
//        toppanel.add(hivefile);
//        toppanel.add(this.hivecb);
//        toppanel.add(tgcharsetlb);
//        toppanel.add(tgcharsetlist);
//        toppanel.add(this.query);
//        toppanel.add(enchangeStart);
//
//        // JPanel tmpPanel = new JPanel();
//        // tmpPanel.add(toppanel, "Center");
//
//        toppanel.setPreferredSize(new Dimension(600, 90));
//        add(toppanel, "North");
//    }

    private void initCenterPanel() {
        jsp = new JScrollPane(this.taInfo);
        jsp.setBounds(100, 90, 450, 300);
        add(jsp, "Center");
    }

//    @Override
//    public void actionPerformed(ActionEvent event) {
//        Object ob = event.getSource();
//        if (ob == this.about) {
//            System.out.println("about");
//            // JFrame jf = new JFrame("about");
//            // jf.setSize(200, 100);
//            // jf.setVisible(true);
//        } else if (ob.equals(this.exitMenu)) {
//            System.exit(0);
//        } else if (ob.equals(this.chooseflo)) {
//            JFileChooser jfc = new JFileChooser();
//            jfc.setDialogTitle("请选择需要转换的文件夹\\文件");
//            jfc.setFileFilter(this.dirctoryFileFilter);
//            jfc.setMultiSelectionEnabled(true);
//            jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//            jfc.setApproveButtonText("确定");
//            jfc.showOpenDialog(this);
//            // TODO 记住用户选择的文件
//            File[] files = jfc.getSelectedFiles();
//            this.converController.setTempFile(files);
//            if (files.length != 0) {// 等于一个的时候可能是一个文件夹也可能是一个文件
//                String tgdirpath;
//                if (files.length == 1)
//                    tgdirpath = files[0].isDirectory() ? files[0].getPath()
//                            : files[0].getParent();
//                else
//                    tgdirpath = files[0].getParent();
//                this.tgdir.setText(tgdirpath);
//                this.tgdir_temp = this.tgdir.getText();
//
//            }
//
//        } else if (ob.equals(this.tgcharsetlist)) {
//            this.converController
//                    .setTgEncoding((String) this.tgcharsetlist.getSelectedItem());
//        } else if (ob.equals(this.hivecb)) {
//            // System.out.println("hivecb");
//            this.converController.setHive(this.hivecb.isSelected());
//        } else if (ob.equals(this.query)) {
//            // System.out.println("query");
//            this.checkAdtype();
//            this.checkTgdir();
//            this.checkTgtype();
//            this.converController.query(true);
//            // int height=10;
//            // Point p = new Point();
//            // System.out.println("count : " + this.taInfo.getLineCount());
//            // p.setLocation(0,this.taInfo.getLineCount()*height);
//            // this.jsp.setLocation(p);
//        } else if (ob.equals(this.enchangeStart)) {
//            this.checkAdtype();
//            this.checkTgdir();
//            this.checkTgtype();
//            this.converController.encodingConvertStart();
//        }
//    }

    public ConvertorFrame(FrameConfig config) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
//        super("Encoding Convertor");
        super(config.getTitle());
        setBounds(config.getX(), config.getY(), config.getWidth(), config.getWidth());
        URL url = ConvertorFrame.class.getResource(config.getFrameIcon());
        setIconImage(ImageIO.read(url));
        List<PanelConfig> panels = config.getPanelsConfig();
        for(PanelConfig i: panels){
            Panel panel = (Panel) Class.forName(i.getClassname()).newInstance();
            panel.setPreferredSize(new Dimension(i.getWidth(),i.getHeight()));
//            if(i.getLabelsConfig() != null){
//                initJLabels(i.getLabelsConfig(),panel);
//            }
//            if(i.getBoxsConfig() != null){
//                initJBoxs(i.getBoxsConfig(),panel);
//            }
//            if(i.getButtonsConfig() != null){
//                initJButtons(i.getButtonsConfig(),panel);
//            }
//            if(i.getTextFieldsConfig() != null){
//                initJTextFields(i.getTextFieldsConfig(),panel);
//            }
            for(ComponentConfig j:i.getComponentConfig()){
                initComponent(j,panel);
            }
            add(panel,i.getAlign());
            
        }
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

    /**
 *
 * @param j
 * @param panel
     * @throws ClassNotFoundException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @throws NoSuchMethodException 
     * @throws SecurityException 
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
 */
private void initComponent(ComponentConfig config, Panel panel) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
    if(config.getGroups() != null){
        List<ComponentConfig> groups  =  config.getGroups();
        initComponentGroup(groups,panel);
        return;
    }
    JComponent component = (JComponent) Class.forName(config.getClassname()).newInstance();
    component.setBounds(config.getX(), config.getY(), config.getWidth(), config.getHeight());
    if(config.getAlign() != null){
        if(component instanceof JLabel){
            ((JLabel) component).setText(config.getText());
        }
    }
    if(config.getListener() != null){
        Constructor<?> con =  Class.forName(config.getClassname()).getConstructor(ConvertorFrame.class,Object.class);
        if(component instanceof JButton){
            ((JButton) component).addActionListener((ActionListener) con.newInstance(this,component));
        }else if(component instanceof JTextField){
            ((JTextField) component).addActionListener((ActionListener) con.newInstance(this,component));
        }else if(component instanceof JCheckBox){
            ((JCheckBox) component).addActionListener((ActionListener) con.newInstance(this,component));
        }else if(component instanceof JComboBox){
            ((JComboBox) component).addActionListener((ActionListener) con.newInstance(this,component));
        }
    }
    if(config.getText() != null){
        if(component instanceof JLabel){
            ((JLabel) component).setText(config.getText());
        }else if(component instanceof JButton){
            ((JButton) component).setText(config.getText());
        }
    }
    
}

private void initComponentGroup(List<ComponentConfig> groups,Panel panel){
    
}

    /**
     *
     * @param textFieldsConfig
     * @param panel
     * @throws ClassNotFoundException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     * @throws NoSuchMethodException 
     * @throws SecurityException 
     */
    private void initJTextFields(List<TextFieldConfig> textFieldsConfig, Panel panel) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, SecurityException, NoSuchMethodException {
        for(TextFieldConfig t:textFieldsConfig){
            JTextField field = (JTextField) Class.forName(t.getClassname()).newInstance();
            field.setBounds(t.getX(), t.getY(), t.getWidth(), t.getHeight());
            Constructor<?> listener = Class.forName(t.getListener()).getConstructor(ConvertorFrame.class,JTextField.class);
            field.addActionListener((ActionListener) listener.newInstance(this,field));
            panel.add(field);
        }
    }

    /**
     *
     * @param buttonsConfig
     * @param panel
     * @throws ClassNotFoundException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @throws NoSuchMethodException 
     * @throws SecurityException 
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     */
    private void initJButtons(List<ButtonConfig> buttonsConfig, Panel panel) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        for(ButtonConfig b:buttonsConfig){
            JButton button = (JButton) Class.forName(b.getClassname()).newInstance();
            button.setText(b.getText());
            button.setBounds(b.getX(), b.getY(), b.getWidth(), b.getHeight());
            Constructor<?> listener = Class.forName(b.getListener()).getConstructor(ConvertorFrame.class,JButton.class);
            button.addActionListener((ActionListener) listener.newInstance(this,button));
            panel.add(button);
        }
    }

    /**
     *
     * @param boxsConfig
     * @param panel
     * @return
     * @throws ClassNotFoundException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @throws NoSuchMethodException 
     * @throws SecurityException 
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     */
    private void initJBoxs(List<BoxConfig> boxsConfig, Panel panel) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        for(BoxConfig b:boxsConfig){
             Object j = Class.forName(b.getClassname()).newInstance();
             if(j instanceof javax.swing.JComboBox){
                 ((javax.swing.JComboBox) j).setBounds(b.getX(), b.getY(), b.getWidth(), b.getHeight());
                 Constructor<?> listener = Class.forName(b.getListener()).getConstructor(ConvertorFrame.class,JComboBox.class);
                 ((javax.swing.JComboBox) j).addActionListener((ActionListener) listener.newInstance(this,((javax.swing.JComboBox) j)));
                 panel.add(((javax.swing.JComboBox) j));
             }else if(j instanceof javax.swing.JCheckBox){
                 ((javax.swing.JCheckBox) j).setBounds(b.getX(), b.getY(), b.getWidth(), b.getHeight());
                 Constructor<?> listener = Class.forName(b.getListener()).getConstructor(ConvertorFrame.class,JCheckBox.class);
                 ((javax.swing.JCheckBox) j).addActionListener((ActionListener) listener.newInstance(this,((javax.swing.JCheckBox) j)));
                 panel.add(((javax.swing.JCheckBox) j));
             }
        }
    }

    /**
     *
     * @param labelsConfig
     * @param panel 
     * @return
     * @throws ClassNotFoundException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    private void initJLabels(List<LabelConfig> labelsConfig, Panel panel) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        for(LabelConfig l : labelsConfig){
            JLabel label = (JLabel) Class.forName(l.getClassname()).newInstance();
            label.setText(l.getText());
            label.setBounds(l.getX(), l.getY(), l.getWidth(), l.getHeight());
            label.setHorizontalTextPosition(Integer.parseInt(l.getAlign()));
            panel.add(label);
        }
    }

    public static void main(String[] args) throws Exception {
        try {
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
            UIManager.put("RootPane.setupButtonVisible", false);

        } catch (Exception e) {

        }

//        ConvertorFrame mainframe = new ConvertorFrame();
//        URL url = ConvertorFrame.class.getResource("/img/motug.png");
//        Image image = ImageIO.read(url);
//        mainframe.setIconImage(image);
    }

//    @Override
//    public void focusGained(FocusEvent e) {
//    }
//
//    @Override
//    public void focusLost(FocusEvent e) {
//        Object r = e.getSource();
//        if (r.equals(this.tgdir)) {
//            this.checkTgdir();
//        } else if (r.equals(this.adType)) {
//            this.checkAdtype();
//        } else if (r.equals(this.tgType)) {
//            this.checkTgtype();
//        }
//    }

//    public void checkTgdir() {
//        if (!this.tgdir.getText().equals(this.tgdir_temp)) {
//            this.tgdir_temp = this.tgdir.getText();
//            this.converController.setTempFile(this.tgdir.getText());
//        }
//    }

//    public void checkAdtype() {
//        if (!this.adType.getText().equals(this.adtype_temp)) {
//            this.adtype_temp = this.adType.getText();
//            this.converController.setAdType(this.adType.getText());
//        }
//    }

//    public void checkTgtype() {
//        if (!this.tgType.getText().equals(this.tgtype_temp)) {
//            this.tgtype_temp = this.tgType.getText();
//            this.converController.setTgType(this.tgType.getText());
//        }
//    }

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
