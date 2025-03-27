import 'dart:convert';
import 'dart:io';

void main() {
  // Load danh sách học sinh từ file JSON
  List<Student> students = loadStudents();

  // Kiểm tra nếu danh sách rỗng (có thể do lỗi file)
  if (students.isEmpty) {
    print("⚠️ Không có dữ liệu học sinh.");
  } else {
    // Hiển thị danh sách học sinh
    print(" Danh sách học sinh:");
    for (var student in students) {
      print(student);
    }
  }

  // Lưu dữ liệu vào file JSON sau khi chỉnh sửa
  saveStudents(students);
}

/// Model Student
class Student {
  int id;
  String name;
  List<Subject> subjects;

  Student({required this.id, required this.name, required this.subjects});

  // Parse từ JSON
  factory Student.fromJson(Map<String, dynamic> json) {
    return Student(
      id: json['id'],
      name: json['name'],
      subjects: (json['subjects'] as List)
          .map((subj) => Subject.fromJson(subj))
          .toList(),
    );
  }

  // Chuyển thành JSON
  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'name': name,
      'subjects': subjects.map((subj) => subj.toJson()).toList(),
    };
  }

  @override
  String toString() {
    return 'ID: $id, Name: $name, Subjects: $subjects';
  }
}

/// Model Subject
class Subject {
  String name;
  List<double> scores;

  Subject({required this.name, required this.scores});

  // Parse từ JSON
  factory Subject.fromJson(Map<String, dynamic> json) {
    return Subject(
      name: json['name'],
      scores: List<double>.from(json['scores'].map((s) => s.toDouble())),
    );
  }

  // Chuyển thành JSON
  Map<String, dynamic> toJson() {
    return {
      'name': name,
      'scores': scores,
    };
  }

  @override
  String toString() {
    return '{Subject: $name, Scores: $scores}';
  }
}

/// Hàm đọc dữ liệu từ file JSON
List<Student> loadStudents() {
  final file = File('students.json');

  if (!file.existsSync()) {
    print(" File không tồn tại! Trả về danh sách rỗng.");
    return []; // 
  }

  final contents = file.readAsStringSync();
  if (contents.trim().isEmpty) {
    print(" File rỗng! Trả về danh sách trống.");
    return [];
  }

  try {
    final Map<String, dynamic> jsonData = jsonDecode(contents);
    return (jsonData['students'] as List)
        .map((student) => Student.fromJson(student))
        .toList();
  } catch (e) {
    print(" Lỗi khi đọc JSON: $e");
    return [];
  }
}

/// Hàm ghi dữ liệu vào file JSON
void saveStudents(List<Student> students) {
  final file = File('students.json');
  final jsonData = {
    'students': students.map((student) => student.toJson()).toList(),
  };

  file.writeAsStringSync(jsonEncode(jsonData), flush: true);
  print("✅ Dữ liệu đã được lưu!");
}
