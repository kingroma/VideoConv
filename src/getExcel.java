import java.io.FileInputStream;


public class getExcel {
	public getExcel(){
		
	}
	/*
	public double[] getExcelSec(String path){
		double[] output = null;
		System.out.println(path+" Ȯ���� ... ");
		try{
			FileInputStream fis=new FileInputStream(path);
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			int rowindex=0;
			int columnindex=0;
			//��Ʈ �� (ù��°���� �����ϹǷ� 0�� �ش�)
			//���� �� ��Ʈ�� �б����ؼ��� FOR���� �ѹ��� �����ش�
			XSSFSheet sheet=workbook.getSheetAt(0);
			
			
			//���� ��
			int rows=sheet.getPhysicalNumberOfRows();
			output  = new double[rows];
			for(rowindex=0;rowindex<rows;rowindex++){
				
			    //�����д´�
			    XSSFRow row=sheet.getRow(rowindex);
			    
			    System.out.println();
			    System.out.print(" ["+rowindex+"] ");
			    
			    if(row !=null){
			        //���� ��
			        int cells=row.getPhysicalNumberOfCells();
			        for(columnindex=0;columnindex<=cells;columnindex++){
			            //������ �д´�
			            XSSFCell cell=row.getCell(columnindex);
			            String value="";
			            //���� ���ϰ�츦 ���� ��üũ
			            if(cell==null){
			                continue;
			            }else{
			                //Ÿ�Ժ��� ���� �б�
			                switch (cell.getCellType()){
			                case XSSFCell.CELL_TYPE_FORMULA:
			                    value=cell.getCellFormula();
			                    break;
			                case XSSFCell.CELL_TYPE_NUMERIC:
			                    value=cell.getNumericCellValue()+"";
			                    break;
			                case XSSFCell.CELL_TYPE_STRING:
			                    value=cell.getStringCellValue()+"";
			                    break;
			                case XSSFCell.CELL_TYPE_BLANK:
			                    value=cell.getBooleanCellValue()+"";
			                    break;
			                case XSSFCell.CELL_TYPE_ERROR:
			                    value=cell.getErrorCellValue()+"";
			                    break;
			                }
			            }
			            System.out.print(" / "+value+"");
			            output[rowindex] = Double.parseDouble(value);
			        }
			    }
			}

		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("excel load finish");
		System.out.println();
		return output;
		
	}
	*/
}
