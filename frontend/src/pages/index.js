import { Inter } from 'next/font/google'
import React, {
  useState
} from 'react';
import FileUpload from './FileUpload';
const inter = Inter({ subsets: ['latin'] })

export default function Home() {
    const [employees, setEmployees] = useState([]);
    const [jobSummary, setJobSummary] = useState([]);

    const handleFileUpload = async (file) => {
      const formData = new FormData();
      formData.append('file', file);

      try {
        const response = await fetch('http://localhost:8080/api/employees/upload', {
          method: 'POST',
          body: formData,
        });

        if (response.ok) {
          const data = await response.json();
          setEmployees(data.employees);
          setJobSummary(data.jobSummary);
        } else {
          console.error('File upload failed');
        }
      } catch (error) {
        console.error('Error during file upload', error);
      }
    };
  return (
     <div>
            <h1>CSV Parser and UI</h1>
            <FileUpload onFileUpload={handleFileUpload} />

            {/* Table 1: Employee information */}
            <h2>Employee Information</h2>
            <table>
                {/* Display paginated list of employees */}
                {/* Use a pagination library or implement your own logic */}
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Job Title</th>
                        <th>Salary</th>
                    </tr>
                </thead>
                <tbody>
                    {employees.map((employee) => (
                        <tr key={employee.id}>
                            <td>{employee.id}</td>
                            <td>{employee.employeeName}</td>
                            <td>{employee.jobTitle}</td>
                            <td>{employee.salary}</td>
                        </tr>
                    ))}
                </tbody>
            </table>

            {/* Table 2: Jobs summary */}
            <h2>Jobs Summary</h2>
            <table>
                {/* Display average salary for each job title */}
                <thead>
                    <tr>
                        <th>Job Title</th>
                        <th>Average Salary</th>
                    </tr>
                </thead>
                <tbody>
                    {jobSummary.map((summary) => (
                        <tr key={summary.jobTitle}>
                            <td>{summary.jobTitle}</td>
                            <td>{summary.averageSalary}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
  )
}
