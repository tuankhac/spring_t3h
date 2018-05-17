
package com.neo.util;


public class HtmlStringUtil
{
	/* �^�u�������󔒕����ɒu������ۂ̋󔒕����� */
	protected static final int MAX_TAB_TO_SPACE_CHAR = 4;

	/**
	 * �T�j�^�C�W���O���s��<Br>
	 * @param targetStr �����̑ΏۂƂȂ镶����
	 * @param changeTab �^�u�����̒u���L��(true=�L/false=��)
	 * @return ������̕�����
	 */
	public static String sanitizing( String targetStr, boolean changeTab ) {

		if((targetStr == null)||(targetStr.length() == 0)){
			return targetStr;
		}

		// �T�j�^�C�W���O���@��ύX
		StringBuffer sbTmp = new StringBuffer(0);

		int len = targetStr.length();
		for(int cnt = 0 ; cnt < len ; cnt++) {

			char moji = targetStr.charAt(cnt);

			switch(moji) {
			  case ';' :
				sbTmp.append("&#59;");
				break;

			  case '&' :
				sbTmp.append("&amp;");
				break;

			  case '"' :
				sbTmp.append("&quot;");
				break;

			  case '<' :
				sbTmp.append("&lt;");
				break;

			  case '>' :
				sbTmp.append("&gt;");
				break;

			  case '\'' :
				sbTmp.append("&#39;");
				break;

			  case '%' :
				sbTmp.append("&#37;");
				break;

			  case '(' :
				sbTmp.append("&#40;");
				break;

			  case ')' :
				sbTmp.append("&#41;");
				break;

			  case '+' :
				sbTmp.append("&#43;");
				break;

			  case '\t' :
				// �^�u�u���L��̏ꍇ�́A�󔒕����ɒu������
				if(changeTab) {
					for(int cnt2 = 0 ; cnt2 < MAX_TAB_TO_SPACE_CHAR ; cnt2++) {
						sbTmp.append("&nbsp;");
					}
				}
				else {
					sbTmp.append(moji);
				}
				break;
				
			  default :
				sbTmp.append(moji);
				break;
			}
		}

		return sbTmp.toString();
	}

	/**
	 * ���s�L����HTML���s�^�O+���s�L���ɒu������B<Br>
	 * @param targetStr �����̑ΏۂƂȂ镶����
	 * @return ������̕�����
	 */
	public static String replaceReturn( String targetStr ) {
		String returnStr;
		
		// ���s�L����"\n"�ɓ��ꂷ��
		returnStr = targetStr.replaceAll("\r\n", "\n");
		
		// ���s�L���̑O��HTML���s�^�O��}������
		returnStr = targetStr.replaceAll("\n", "<br />\n");
		
		return returnStr;
	}

	/**
	 * �X�y�[�X������HTML�X�y�[�X�����ɒu������B<Br>
	 * @param targetStr �����̑ΏۂƂȂ镶����
	 * @return ������̕�����
	 */
	public static String replaceSpace( String targetStr ) {
		String returnStr;

		// ���p�X�y�[�X��HTML�X�y�[�X����1�ɒu������
		returnStr = targetStr.replaceAll(" ", "&nbsp;");

		// �S�p�X�y�[�X��HTML�X�y�[�X����2�ɒu������
		returnStr = returnStr.replaceAll("�@", "&nbsp;&nbsp;");

		return returnStr;
	}
}

