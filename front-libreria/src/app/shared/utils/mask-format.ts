export class MaskFormatHelper {

  static partNoFormat(cellInfo) {
    const formatted = cellInfo.valueText.replace(/^([0-9a-zA-Z]{3})([0-9a-zA-Z]{2})([0-9a-zA-Z]{2})([0-9a-zA-Z]{3})/, '$1.$2.$3.$4');
    return formatted;
  }

  static workOrderCodeFormat(cellInfo){
    const codeFormatted = cellInfo.valueText.replace(/^([0-9a-zA-Z]{3})([0-9a-zA-Z]{2})([0-9a-zA-Z]{4})/, '$1.$2.$3');
    return codeFormatted;
  }

  static componentCodeFormat(cellInfo){
    const codeFormatted = cellInfo.valueText.replace(/^([0-9a-zA-Z]{3})([0-9a-zA-Z]{2})([0-9a-zA-Z]{4})/, '$1.$2.$3');
    return codeFormatted;
  }

  static partNoFormatNoCell(value: string) {
    const formatted = value.replace(/^([0-9a-zA-Z]{3})([0-9a-zA-Z]{2})([0-9a-zA-Z]{2})([0-9a-zA-Z]{3})/, '$1.$2.$3.$4');
    return formatted;
  }

  static partNoMask(){
    return 'AAA.AA.AA.AAA';
  }

  static poNoFormat(cellInfo) {
    const formatted = cellInfo.valueText.replace(/^([0-9a-zA-Z]{3})([0-9a-zA-Z]{2})([0-9a-zA-Z]{2})([0-9a-zA-Z]{3})/, '$1/$2/$3/$4');
    return formatted;
  }
}