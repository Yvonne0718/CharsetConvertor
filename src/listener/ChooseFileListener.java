/*
 * Copyright(C) 2013 Agree Corporation. All rights reserved.
 * 
 * Contributors:
 *     Agree Corporation - initial API and implementation
 */
package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;

import controller.ConvertController;
import ui.ConvertorFrame;

/**
 *
 *
 * @author Lee
 * @date 2017��8��22�� ����5:02:51
 * @version 1.0
 *
 */
public class ChooseFileListener implements ActionListener {
    private ConvertorFrame frame;
    private ConvertController converController;
    public ChooseFileListener(ConvertController converController, ConvertorFrame frame){
        this.frame = frame;
        this.converController = converController;
    }
    /* 
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser jfc = new JFileChooser();
        jfc.setDialogTitle("��ѡ����Ҫת�����ļ���\\�ļ�");
        jfc.setFileFilter(this.dirctoryFileFilter);
        jfc.setMultiSelectionEnabled(true);
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        jfc.setApproveButtonText("ȷ��");
        jfc.showOpenDialog(this.frame);
        // TODO ��ס�û�ѡ����ļ�
        File[] files = jfc.getSelectedFiles();
        this.converController.setTempFile(files);
        if (files.length != 0) {// ����һ����ʱ�������һ���ļ���Ҳ������һ���ļ�
            String tgdirpath;
            if (files.length == 1)
                tgdirpath = files[0].isDirectory() ? files[0].getPath()
                        : files[0].getParent();
            else
                tgdirpath = files[0].getParent();
            this.frame.tgdir.setText(tgdirpath);
            this.frame.tgdir_temp = this.frame.tgdir.getText();

        }
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
